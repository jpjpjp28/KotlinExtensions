package com.jpjpjp28.kotlinextensions

import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by john.custodio on 03/11/2017.
 */

/**
 * Add a fragment to the fragment state.  This fragment may optionally
 * also have its view (if {@link Fragment#onCreateView Fragment.onCreateView}
 * returns non-null) into a container view of the fragment.
 *
 * @receiver Fragment
 * @param fragment The new fragment to place in the container.
 * @param frameId Identifier of the container whose fragment(s) are
 */
fun Fragment.addFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.transact { add(frameId, fragment) }
}

/**
 * Re-attach a fragment after it had previously been detached from
 * the UI with {@link #detach(Fragment)}.  This
 * causes its view hierarchy to be re-created, attached to the UI,
 * and displayed.
 *
 * @receiver Fragment
 * @param fragment The fragment to be attached.
 */
fun Fragment.attachFragment(fragment: Fragment) {
    childFragmentManager.transact { attach(fragment) }
}

/**
 * Detach the given fragment from the UI.  This is the same state as
 * when it is put on the back stack: the fragment is removed from
 * the UI, however its state is still being actively managed by the
 * fragment manager.  When going into this state its view hierarchy
 * is destroyed.
 *
 * @receiver Fragment
 * @param fragment The fragment to be detach.
 */
fun Fragment.detachFragment(fragment: Fragment) {
    childFragmentManager.transact { detach(fragment) }
}

/**
 * Shows a previously hidden fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be shown.
 *
 * @receiver Fragment
 * @param fragment The fragment to be shown.
 */
fun Fragment.showFragment(fragment: Fragment) {
    childFragmentManager.transact { show(fragment) }
}

/**
 * Hides an existing fragment.  This is only relevant for fragments whose
 * views have been added to a container, as this will cause the view to
 * be hidden.
 *
 * @receiver Fragment
 * @param fragment The fragment to be hidden.
 */
fun Fragment.hideFragment(fragment: Fragment) {
    childFragmentManager.transact { hide(fragment) }
}

/**
 * Replace an existing fragment that was added to a container.  This is
 * essentially the same as calling {@link #remove(Fragment)} for all
 * currently added fragments that were added with the same containerViewId
 * and then {@link #add(int, Fragment, String)} with the same arguments
 * given here.
 *
 * @receiver Fragment
 * @param fragment The new fragment to place in the container.
 * @param frameId Identifier of the container whose fragment(s) are to be replaced.
 */
fun Fragment.replaceFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.transact { replace(frameId, fragment) }
}

/**
 * Remove an existing fragment.  If it was added to a container, its view
 * is also removed from that container.
 *
 * @receiver Fragment
 * @param fragment Fragment The fragment to be removed.
 */
fun Fragment.removeFragment(fragment: Fragment) {
    childFragmentManager.transact { remove(fragment) }
}

/**
 * Start a series of edit operations on the Fragments associated with
 * this FragmentManager and schedules a commit of this transaction.
 *
 * <p>Note: A fragment transaction can only be created/committed prior
 * to an activity saving its state.  If you try to commit a transaction
 * after {@link FragmentActivity#onSaveInstanceState FragmentActivity.onSaveInstanceState()}
 * (and prior to a following {@link FragmentActivity#onStart FragmentActivity.onStart}
 * or {@link FragmentActivity#onResume FragmentActivity.onResume()}, you will get an error.
 * This is because the framework takes care of saving your current fragments
 * in the state, and if changes are made after the state is saved then they
 * will be lost.</p>
 *
 * @author John Paul Custodio
 * @receiver FragmentManager
 * @param func Series of edit operations
 */
inline fun FragmentManager.transact(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

/**
 * Start a series of edit operations on the Fragments associated with
 * this FragmentManager.
 *
 * @author John Paul Custodio
 * @receiver FragmentManager
 * @param func Series of edit operations
 */
inline fun FragmentManager.transactAddToBackStack(func: FragmentTransaction.() -> FragmentTransaction): FragmentTransaction {
    return beginTransaction().func().addToBackStack(null)
}