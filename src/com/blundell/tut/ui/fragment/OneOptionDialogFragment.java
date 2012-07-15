package com.blundell.tut.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class OneOptionDialogFragment<T> extends DialogFragment implements OnClickListener {
	private static final String ARG_TITLE = "com.blundell.tut.ui.fragment.OneOptionDialogFragment.ARG_TITLE";
	private static final String ARG_MESSAGE = "com.blundell.tut.ui.fragment.OneOptionDialogFragment.ARG_MESSAGE";
	private static final String ARG_BUTTON_TEXT = "com.blundell.tut.ui.fragment.OneOptionDialogFragment.ARG_BUTTON_TEXT";

	private OnDialogOptionClickListener<T> clickListener;
	private T item;

	public interface OnDialogOptionClickListener<T extends Object> {
		void onDialogOptionPressed(T object);
	}

	public static <T> OneOptionDialogFragment<T> newInstance(String title, String message, String buttonText){
		OneOptionDialogFragment<T> fragment = new OneOptionDialogFragment<T>();

		Bundle args = new Bundle();
		args.putString(ARG_TITLE, title);
		args.putString(ARG_MESSAGE, message);
		args.putString(ARG_BUTTON_TEXT, buttonText);
		fragment.setArguments(args);

		return fragment;
	}

	public void addItem(T item){
		this.item = item;
	}

	public void setOnDialogOptionClickListener(OnDialogOptionClickListener<T> clickListener){
		this.clickListener = clickListener;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Bundle args = getArguments();
		String title = args.getString(ARG_TITLE);
		String message = args.getString(ARG_MESSAGE);
		String buttonText = args.getString(ARG_BUTTON_TEXT);

		return new AlertDialog.Builder(getActivity())
		.setIcon(android.R.drawable.ic_dialog_info)
		.setTitle(title)
		.setMessage(message)
		.setPositiveButton(buttonText, this).create();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if(this.clickListener != null){
			this.clickListener.onDialogOptionPressed(item);
		}
	}
}