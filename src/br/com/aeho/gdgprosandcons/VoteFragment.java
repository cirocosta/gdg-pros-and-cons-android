package br.com.aeho.gdgprosandcons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VoteFragment extends Fragment {

	static View sView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		sView = inflater.inflate(R.layout.vote_fragment, container, false);
		initializeUi(sView);

		return sView;
	}

	private void initializeUi(View view) {

	}

}
