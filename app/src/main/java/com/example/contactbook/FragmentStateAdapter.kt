package com.example.contactbook

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.contactbook.phonebook.PhoneBookFragment

class FragmentStateAdapter(ma: MainActivity) : FragmentStateAdapter(ma) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> PhoneBookFragment.newInstance()
        1 -> FavoriteFragment.newInstance()
        else -> AddContactFragment.newInstance()
    }
}