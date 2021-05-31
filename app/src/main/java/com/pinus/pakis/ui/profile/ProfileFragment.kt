package com.pinus.pakis.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.R
import com.pinus.pakis.databinding.FragmentProfileBinding
import com.pinus.pakis.ui.aboutus.AboutUsActivity
import com.pinus.pakis.ui.account.Account
import com.pinus.pakis.ui.auth.SignupSigninActivity
import com.pinus.pakis.ui.profile_account.ProfileAccountActivity

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        user = auth.currentUser!!
        clickItem()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun clickItem() {
        with(binding) {
            tvTentangKami.setOnClickListener {
                val intent = Intent(context, AboutUsActivity::class.java)
                startActivity(intent)
            }

            tvProfile.setOnClickListener {
                val intent = Intent(context, ProfileAccountActivity::class.java)
                startActivity(intent)
            }

            tvAkun.setOnClickListener {
                val intent = Intent(context, Account::class.java)
                startActivity(intent)
            }
            tvKeluar.setOnClickListener {
                val dialog = MaterialAlertDialogBuilder(requireContext())
                    .setTitle(resources.getString(R.string.exit))
                    .setMessage(resources.getString(R.string.exit_confirm))
                    .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                        // Respond to neutral button press
                        dialog.cancel()
                    }
                    .setPositiveButton(resources.getString(R.string.exit)) { dialog, which ->
                        // Respond to positive button press
                        auth.signOut()
                        val intent = Intent(context, SignupSigninActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP;
                        startActivity(intent);
                    }
                    .show()

                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED)
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.GRAY)
            }
        }
    }
}