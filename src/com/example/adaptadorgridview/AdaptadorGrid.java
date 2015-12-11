package com.example.adaptadorgridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class AdaptadorGrid extends Activity implements OnItemClickListener {
	
	private Titulos[] opciones = new Titulos[]{
			new Titulos("Título 1", "Subtítulo fdfgdfdfgfd ffdg1"),
			new Titulos("Título 2", "Subtítulo sdgf 2"),
			new Titulos("Título 3", "Subtítulo fdgdfdfgdfg 3"),
			new Titulos("Título 4", "Subtítulo dfgdfgdg 4"),
			new Titulos("Título 5", "Subtítulo dfgdfgdfgdfgdgdf 5"),
			new Titulos("Título 6", "Subtítulo dfgdfgdsdfg 6"),
			new Titulos("Título 7", "Subtítulo dfgdfgsfsdffsfdsfsdfdg 7"),
			new Titulos("Título 8", "Subtítulo dfgdffdffddfgdg 8"),
			new Titulos("Título 9", "Subtítulo dfgdsdfsdgsdfgdg 9"),
			new Titulos("Título 10", "Subtítulo dfgdfgdg 10"),
			new Titulos("Título 11", "Subtítulo dfgsdgsdgdfgdgdfgdg 11"),
			new Titulos("Título 12", "Subtítulo dfgdfgdfgdfgdg 12"),
			new Titulos("Título 13", "Subtítulo dfgdfgdg 13")};

	private TextView lblEtiqueta;
	private GridView gridOpciones;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adaptador_grid);
		
		lblEtiqueta = (TextView)findViewById(R.id.lblEtiqueta);
		gridOpciones = (GridView) findViewById(R.id.gridOpciones);
		//ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);
		/* XML*/// ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valoresOpciones, android.R.layout.simple_list_item_1);
		AdaptadorTitulos adaptador = new AdaptadorTitulos(this);
		gridOpciones.setAdapter(adaptador);
		gridOpciones.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adaptador_grid, menu);
		return true;
	}
	

	class AdaptadorTitulos extends ArrayAdapter<Titulos> {

		Activity context;

		AdaptadorTitulos(Activity context) {
			super(context, R.layout.lista_con_titulos, opciones);
			this.context = context;
		}

		public View getView(int posicion, View convertView, ViewGroup parent) {

			View vItem = convertView;
			ViewHolder holder; // guardar los controles

			if (vItem == null){
				LayoutInflater inflater = context.getLayoutInflater();
				vItem = inflater.inflate(R.layout.lista_con_titulos, null);

				holder = new ViewHolder();
				holder.titulo = (TextView)vItem.findViewById(R.id.lblTitulo);
				holder.subtitulo = (TextView)vItem.findViewById(R.id.lblSubtitulo);
				vItem.setTag(holder);
			}
			else
			{
				holder = (ViewHolder)vItem.getTag();
			}

			holder.titulo.setText(opciones[posicion].getTitulo());
			holder.subtitulo.setText(opciones[posicion].getSubtitulo());

			return(vItem);
		}

	}

	static class ViewHolder {
		TextView titulo;
		TextView subtitulo;
	}

	public void onItemClick(AdapterView<?> adap, View v, int posicion, long arg3) {
		lblEtiqueta.setText("Opción seleccionada: " + opciones[posicion].getTitulo());
	}
}

