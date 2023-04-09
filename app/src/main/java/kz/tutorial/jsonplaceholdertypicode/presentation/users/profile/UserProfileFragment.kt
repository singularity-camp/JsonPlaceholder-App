package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.tutorial.jsonplaceholdertypicode.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

private const val CURRENT_USER_ID = 2

class UserProfileFragment : Fragment() {
    private val vm: UserProfileViewModel by viewModel {
        parametersOf(args.userId, CURRENT_USER_ID)
    }

    private val args: UserProfileFragmentArgs by navArgs()

    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvFullname: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvWebsite: TextView
    private lateinit var tvCompany: TextView
    private lateinit var tvCatchPhrase: TextView
    private lateinit var tvBs: TextView
    private lateinit var tvStreet: TextView
    private lateinit var tvSuite: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvZipcode: TextView
    private lateinit var tvLocation: TextView
    private lateinit var lat: String
    private lateinit var lng: String
    private lateinit var cvTodo: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        vm
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initObservers()
        getFromValues()
        initListeners()
    }

    private fun initViews(view: View) {
        with(view) {
            tvUsername = findViewById(R.id.tv_username)
            tvEmail = findViewById(R.id.tv_email)
            tvFullname = findViewById(R.id.tv_fullname)
            tvPhone = findViewById(R.id.tv_phone)
            tvWebsite = findViewById(R.id.tv_website)
            tvCompany = findViewById(R.id.tv_company)
            tvCatchPhrase = findViewById(R.id.tv_catch_phrase)
            tvBs = findViewById(R.id.tv_bs)
            tvStreet = findViewById(R.id.tv_street)
            tvSuite = findViewById(R.id.tv_suite)
            tvCity = findViewById(R.id.tv_city)
            tvZipcode = findViewById(R.id.tv_zipcode)
            tvLocation = findViewById(R.id.tv_show_on_map)
            cvTodo = findViewById(R.id.cv_todo)
        }
    }

    private fun getFromValues() {
        tvUsername.text = args.username
        tvEmail.text = args.fullname
        tvFullname.text = args.email
    }


    private fun initObservers() {
        vm.userProfile.observe(viewLifecycleOwner) {
            with(it) {
                tvPhone.text = phone
                tvWebsite.text = website
                tvCompany.text = company.name
                tvCatchPhrase.text = company.catchPhrase
                tvBs.text = company.bs
                tvStreet.text = address.street
                tvSuite.text = address.suite
                tvCity.text = address.city
                tvZipcode.text = address.zipcode
                lat = address.geo.lat
                lng = address.geo.lng
            }
        }

        vm.currentUser.observe(viewLifecycleOwner) {
            cvTodo.isVisible = it == CURRENT_USER_ID
        }
    }

    private fun initListeners() {
        tvEmail.setOnClickListener {
            val email = tvEmail.text.toString()
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            startActivity(emailIntent)
        }
        tvPhone.setOnClickListener {
            val number = tvPhone.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(callIntent)
        }
        tvWebsite.setOnClickListener {
            val url = "https://${tvWebsite.text}"
            val websiteIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(websiteIntent)
        }
        tvLocation.setOnClickListener {
            val location = Uri.parse("geo:$lat,$lng")
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            startActivity(mapIntent)
        }
        cvTodo.setOnClickListener {
            findNavController().navigate(
                UserProfileFragmentDirections.actionUserProfileFragmentToToDoFragment(
                    CURRENT_USER_ID
                )
            )
        }
    }
}