package br.com.aeho.gdgprosandcons;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaFragment extends Fragment {

	private View mView, mHeader;
	private ListView mLvLista;
	private TextView mTvTextoHeader;
	private ListaMeetupsAdapter mAdapter;
	private static ArrayList<SimpleMeetup> listaMeetups;
	static {
		listaMeetups = new ArrayList<SimpleMeetup>();
		listaMeetups.add(new SimpleMeetup("Nome", "data"));
		listaMeetups.add(new SimpleMeetup("teste", "data"));
		listaMeetups.add(new SimpleMeetup("Nome", "data"));
		listaMeetups.add(new SimpleMeetup("Nome", "data"));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.lista_frag, container, false);
		initialize(mView);

		mAdapter = new ListaMeetupsAdapter(getActivity(),
				R.layout.lista_frag_row, listaMeetups);
		mLvLista.addHeaderView(mHeader, null, false);
		mLvLista.setAdapter(mAdapter);
		mLvLista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				position--;
				Intent i = new Intent(getActivity(), VoteActv.class);
				startActivity(i);
			}
		});
		return mView;
	}

	private void initialize(View view) {
		final LayoutInflater mInflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mLvLista = (ListView) view.findViewById(R.id.lista_frag_lvLista);
		mHeader = mInflater.inflate(R.layout.lista_frag_header, null);
		mTvTextoHeader = (TextView) mHeader
				.findViewById(R.id.lista_frag_header_tvTexto);
	}

	public static class SimpleMeetup {
		final String nome;
		final String data;

		public SimpleMeetup(String nome, String data) {
			this.nome = nome;
			this.data = data;
		}
	}

	private static class SimpleMeetupHolder {
		TextView tvNome;
		TextView tvData;
	}

	public class ListaMeetupsAdapter extends ArrayAdapter<SimpleMeetup> {

		final Context context;
		final int resource;
		final ArrayList<SimpleMeetup> data;

		public ListaMeetupsAdapter(Context context, int layoutResourceId,
				ArrayList<SimpleMeetup> objects) {
			super(context, layoutResourceId, objects);
			this.context = context;
			this.resource = layoutResourceId;
			this.data = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			SimpleMeetupHolder holder;
			if (convertView == null) {
				holder = new SimpleMeetupHolder();
				final LayoutInflater inflater = ((Activity) context)
						.getLayoutInflater();
				convertView = inflater.inflate(resource, parent, false);
				holder.tvNome = (TextView) convertView
						.findViewById(R.id.lista_frag_row_tvNome);
				holder.tvData = (TextView) convertView
						.findViewById(R.id.lista_frag_row_tvData);
				convertView.setTag(holder);
			} else {
				holder = (SimpleMeetupHolder) convertView.getTag();
			}

			SimpleMeetup item = data.get(position);
			holder.tvNome.setText(item.nome);
			holder.tvData.setText(item.data);
			return convertView;
		}

	}

}
