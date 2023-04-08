package kz.tutorial.jsonplaceholdertypicode.presentation.user_profile

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.UserAddressItem
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.UserCompanyItem
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.UserInfoItem
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openLink
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.showMap
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserProfileFragment(private val userId : Int, private val getUserUseCase: GetUserUseCase) : Fragment() {

    private val vm : UserProfileViewModel by viewModel {
        parametersOf(args.userId)
    }

    private val args : UserProfileFragmentArgs by navArgs()

    private lateinit var currUser : User

    private lateinit var tvUsername : TextView
    private lateinit var itemUserInfo : UserInfoItem
    private lateinit var itemUserCompany : UserCompanyItem
    private lateinit var itemUserAddress : UserAddressItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initObservers()
    }

    private fun initViews(view: View) {
        with(view) {
            tvUsername = findViewById(R.id.tv_username)
            itemUserInfo = findViewById(R.id.item_user_info)
            itemUserAddress = findViewById(R.id.item_user_address)
            itemUserCompany= findViewById(R.id.item_user_company)
        }

        itemUserInfo.tvEmail.setOnClickListener {
            startEmail(currUser.email)
        }

        itemUserInfo.tvPhone.setOnClickListener {
            startCall(currUser.phone)
        }

        itemUserInfo.tvWebsite.setOnClickListener {
            openLink(currUser.website)
        }

        itemUserAddress.btnMap.setOnClickListener {
            showMap()
        }

    }

    private fun openLink(link : String) {
        context?.openLink(link)
    }

    private fun startEmail(email : String) {
        context?.startEmail(email)
    }

    private fun startCall(phone : String) {
        checkPermission()
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(),
                Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                    Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE),
                    42)
            }
        } else {
            // Permission has already been granted
            callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 42) {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay!
                callPhone()
            } else {
                // permission denied, boo! Disable the
                // functionality
            }
            return
        }
    }

    fun callPhone(){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${currUser.phone}"))
        startActivity(intent)
    }

    private fun initObservers() {
        vm.currUser.observe(viewLifecycleOwner) {user ->
            currUser = user

            tvUsername.text = user.username

            itemUserInfo.tvEmail.text = user.email
            itemUserInfo.tvName.text = user.name
            itemUserInfo.tvPhone.text  = user.phone
            itemUserInfo.tvWebsite.text = user.website

            itemUserCompany.tvCompanyName.text = user.company.name
            itemUserCompany.tvFullName.text = user.company.catchPhrase
            itemUserCompany.tvServices.text = user.company.bs

            itemUserAddress.tvStreet.text = user.address.street
            itemUserAddress.tvSuite.text = user.address.suite
            itemUserAddress.tvCity.text = user.address.city
            itemUserAddress.tvZipcode.text = user.address.zipcode
        }
    }

    private fun showMap() {
        context?.showMap(currUser.address.geo.lat, currUser.address.geo.lng)
    }


}