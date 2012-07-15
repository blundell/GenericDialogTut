package com.blundell.tut.ui.phone;

import com.blundell.tut.R;
import com.blundell.tut.domain.UserDetails;
import com.blundell.tut.ui.fragment.OneOptionDialogFragment;
import com.blundell.tut.ui.fragment.OneOptionDialogFragment.OnDialogOptionClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnDialogOptionClickListener<UserDetails> {
    private UserDetails userDetails;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userDetails = new UserDetails(1, "Paul");
    }

    public void onShowDialog(View button){
    	String title = userDetails.getName();
		String message = "Are you sure you want to delete this user?";
		String buttonText = "Delete Permanently";
		OneOptionDialogFragment<UserDetails> dialogFragment = OneOptionDialogFragment.newInstance(title, message, buttonText);
		dialogFragment.addItem(userDetails);
		dialogFragment.setOnDialogOptionClickListener(this);
		dialogFragment.show(getSupportFragmentManager(), "TAG");
    }

	@Override
	public void onDialogOptionPressed(UserDetails object) {
		Toast.makeText(this, "Dialog button was pressed. Received user: "+ userDetails.getName(), Toast.LENGTH_LONG).show();
		Log.i("TUT", "onDialogOptionPressed");
		Log.i("TUT", "User: "+ userDetails.getName());
	}
}