package br.com.aeho.gdgprosandcons;

import java.util.ArrayList;

import br.com.aeho.gdgprosandcons.Utils.Constants;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class VoteFragment extends Fragment {

	private static View sView;
	private GridView mGridPosts;
	private ArrayList<PostIt> mPostIts;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		sView = inflater.inflate(R.layout.vote_fragment, container, false);
		initializeUi(sView);

		final int PAGER_MOOD = getArguments().getInt(Constants.PAGER_MOOD);

		mPostIts = new ArrayList<PostIt>();
		if (PAGER_MOOD == Constants.PAGER_MOOD_BAD) {
		} else {
			mPostIts.add(new PostIt("AHUASH"));
		}
		mGridPosts.setEmptyView(sView.findViewById(R.id.vote_fragment_bEmpty));
		mGridPosts.setAdapter(new PostsGridAdapter(getActivity(), mPostIts));
		mGridPosts.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				PostItDialog dfrag = PostItDialog.newInstance();
				dfrag.show(getChildFragmentManager(), "postiddialog");
			}
		});

		return sView;
	}

	public static class PostIt {
		String texto;

		public PostIt(String texto) {
			this.texto = texto;
		}
	}

	private void initializeUi(View view) {
		mGridPosts = (GridView) view.findViewById(R.id.vote_fragment_gridPosts);
	}

	public class PostsGridAdapter extends BaseAdapter {
		private final Context mContext;
		private final ArrayList<PostIt> data;

		public PostsGridAdapter(Context context, ArrayList<PostIt> data) {
			this.mContext = context;
			this.data = data;
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			PostItHolder holder;
			if (convertView == null) {
				holder = new PostItHolder();
				LayoutInflater inflater = (LayoutInflater) mContext
						.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.vote_fragment_postit,
						null, false);
				holder.tvTexto = (TextView) convertView
						.findViewById(R.id.vote_fragment_postit_tvTexto);
				convertView.setTag(holder);
			} else {
				holder = (PostItHolder) convertView.getTag();
			}
			PostIt item = (PostIt) getItem(position);
			holder.tvTexto.setText(item.texto);
			return convertView;
		}
	}

	private class PostItHolder {
		TextView tvTexto;
	}

	public static class PostItDialog extends DialogFragment {
		static PostItDialog newInstance() {
			PostItDialog d = new PostItDialog();
			return d;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			View view = inflater.inflate(R.layout.vote_fragment_dialog, null);

			builder.setView(view);
			return builder.create();
		}

	}

}
