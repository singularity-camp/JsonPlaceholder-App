package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startEmail
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startGeo
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startPhoneCall
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.startWebsite
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserProfileFragment : Fragment() {
    private val args: UserProfileFragmentArgs by navArgs()
    private val vmUserProfile: UserProfileViewModel by viewModel {
        parametersOf(args.userShort)
    }
    private lateinit var tvUserName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvFullName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvWebsite: TextView
    private lateinit var tvCompanyName: TextView
    private lateinit var tvCompanyFullName: TextView
    private lateinit var tvCompanyBS: TextView
    private lateinit var tvStreet: TextView
    private lateinit var tvSuite: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvZipcode: TextView
    private lateinit var tvLocation: TextView
    private lateinit var lat: String
    private lateinit var lng: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupStartContent()
        initObservers()
        setupListeners()
    }

    private fun initViews(view: View) {
        with(view) {
            tvUserName = findViewById(R.id.profile_tv_username)
            tvEmail = findViewById(R.id.cv_user_contacts_tv_email)
            tvFullName = findViewById(R.id.cv_user_contacts_tv_full_name)
            tvPhone = findViewById(R.id.cv_user_contacts_tv_phone)
            tvWebsite = findViewById(R.id.cv_user_contacts_tv_website)
            tvCompanyName = findViewById(R.id.cv_user_company_tv_company_name)
            tvCompanyFullName = findViewById(R.id.cv_user_company_tv_full_name)
            tvCompanyBS = findViewById(R.id.cv_user_company_tv_business)
            tvStreet = findViewById(R.id.cv_user_address_tv_street)
            tvSuite = findViewById(R.id.cv_user_address_tv_suite)
            tvCity = findViewById(R.id.cv_user_address_tv_city)
            tvZipcode = findViewById(R.id.cv_user_address_tv_zip_code)
            tvLocation = findViewById(R.id.cv_user_address_tv_location)
        }
    }

    private fun setupStartContent() {
        tvUserName.text = args.userShort.username
        tvEmail.text = args.userShort.email
        tvFullName.text = args.userShort.name
    }

    private fun initObservers() {
        vmUserProfile.userProfile.observe(viewLifecycleOwner) {
            with(it) {
                tvPhone.text = phone
                tvWebsite.text = website
                tvCompanyName.text = company.name
                tvCompanyFullName.text = company.catchPhrase
                tvCompanyBS.text = company.bs
                tvStreet.text = address.street
                tvSuite.text = address.suite
                tvCity.text = address.city
                tvZipcode.text = address.zipcode
                lat = address.geo.lat
                lng = address.geo.lng
            }
        }
    }

    private fun setupListeners() {
        tvEmail.setOnClickListener {
            context?.startEmail(tvEmail.text.toString())
        }
        tvPhone.setOnClickListener {
            context?.startPhoneCall(tvPhone.text.toString())
        }
        tvWebsite.setOnClickListener {
            context?.startWebsite(tvWebsite.text.toString())
        }
        tvLocation.setOnClickListener {
            context?.startGeo(lat, lng)
        }
    }
}