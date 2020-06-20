package com.jpjpjp28.kotlinextensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

/**
 * Created by john.custodio on 06/20/2020.
 */

/**
 * Add a fragment to the activity state.  This fragment may optionally
 * also have its view (if {@link Fragment#onCreateView Fragment.onCreateView}
 * returns non-null) into a container view of the activity.
 *
 * @receiver AppCompatActivity
 * @param fragment The new fragment to place in the container.
 * @param frameId Identifier of the container whose fragment(s) are
 */
fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact { add(frameId, fragment, fragment.tag) }
}

/**
 * Re-attach a fragment after it had previously been detached from
 * the UI with {@link #detach(Fragment)}.  This
 * causes its view hierarchy to be re-created, attached to the UI,
 * and displayed.
 *
 * @receiver AppCompatActivity
 * @param fragment The fragment to be attached.
 */
fun AppCompatActivity.attachFragment(fragment: Fragment) {
    supportFragmentManager.transact { attach(fragment) }
}

/**
 * Detach the given fragment from the UI.  This is the same state as
 * when it is put on the back stack: the fragment is removed from
 * the UI, however its state is still being actively managed by the
 * fragment manager.  When going into this state its view hierarchy
 * is destroyed.
 *
 * @receiver AppCompatActivity
 * @param fragment The fragment to be detach.
 */
fun AppCompatActivity.detachFragment(fragment: Fragment) {
    supportFragmentManager.transact { detach(fragment) }
}

/**
 * Shows a previously hidden fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be shown.
 *
 * @receiver AppCompatActivity
 * @param fragment The fragment to be shown.
 */
fun AppCompatActivity.showFragment(fragment: Fragment) {
    supportFragmentManager.transact { show(fragment) }
}

/**
 * Hides an existing fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be hidden.
 *
 * @receiver AppCompatActivity
 * @param fragment The fragment to be hidden.
 */
fun AppCompatActivity.hideFragment(fragment: Fragment) {
    supportFragmentManager.transact { hide(fragment) }
}

/**
 * Replace an existing fragment that was added to a container.  This is
 * essentially the same as calling {@link #remove(Fragment)} for all
 * currently added fragments that were added with the same containerViewId
 * and then {@link #add(int, Fragment, String)} with the same arguments
 * given here.
 *
 * @receiver AppCompatActivity
 * @param fragment The new fragment to place in the container.
 * @param frameId Identifier of the container whose fragment(s) are to be replaced.
 */
fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String? = "") {
    supportFragmentManager.transact { replace(frameId, fragment, tag) }
}

/**
 * Remove an existing fragment.  If it was added to a container, its view
 * is also removed from that container.
 *
 * @receiver AppCompatActivity
 * @param fragment Fragment The fragment to be removed.
 */
fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.transact { remove(fragment) }
}

/**
 * Finds a fragment that was identified by the given id either when inflated
 * from XML or as the container ID when added in a transaction.  This first
 * searches through fragments that are currently added to the manager's
 * activity; if no such fragment is found, then all fragments currently
 * on the back stack associated with this ID are searched.
 *
 * @receiver AppCompatActivity
 * @param id ID of the fragment
 * @return The fragment if found or null otherwise.
 */
fun AppCompatActivity.findFragment(id: Int) = supportFragmentManager.findFragmentById(id)

/**
 * Remove an existing dialog fragment with the same Tag and show the
 * new dialog fragment.
 *
 * @receiver AppCompatActivity
 * @param dialogFragment DialogFragment The fragment to be removed.
 * @param tag Optional tag name for the fragment, to later retrieve the
 *      fragment with {@link FragmentManager#findFragmentByTag(String)
 *      FragmentManager.findFragmentByTag(String)}.
 */
fun AppCompatActivity.showDialogFragment(dialogFragment: DialogFragment, tag: String? = "dialog") {
    val ft: FragmentTransaction
    val prev = supportFragmentManager.findFragmentByTag(tag)

    if (prev != null) {
        ft = supportFragmentManager.transactAddToBackStack { remove(prev) }
    } else {
        ft = supportFragmentManager.beginTransaction()
        ft.addToBackStack(null)
    }

    dialogFragment.show(ft, tag)
}