package br.com.aeho.gdgprosandcons;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaFragment extends Fragment {

	private View view, header;
	private ListView lvLista;
	private TextView tvTextoHeader;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.lista_frag, container, false);
		initialize(view);
		lvLista.addHeaderView(header);
		lvLista.setAdapter(null);
		return view;
	}

	
	private void initialize(View view) {
		LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		lvLista = (ListView) view.findViewById(R.id.lista_frag_lvLista);
		header = inflater.inflate(R.layout.lista_frag_header, null);
		tvTextoHeader = (TextView) header
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

		public ListaMeetupsAdapter(Context context, int resource,
				int layoutResourceId, ArrayList<SimpleMeetup> objects) {
			super(context, resource, layoutResourceId, objects);
			this.context = context;
			this.resource = layoutResourceId;
			this.data = objects;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			SimpleMeetupHolder holder;
			if (convertView == null) {
				holder = new SimpleMeetupHolder();
				LayoutInflater inflater = ((Activity) context)
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
