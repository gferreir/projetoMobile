package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<UserModel> userModelArrayList;

    public CustomAdapter(Context context, ArrayList<UserModel> userModelArrayList) {

        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }

    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.inicio, null, true);

            holder.sala = (TextView) convertView.findViewById(R.id.txtSala);
            holder.funcionario = (TextView) convertView.findViewById(R.id.txtFuncionario);
            holder.tipo = (TextView) convertView.findViewById(R.id.txtTipoLimpeza);
            holder.produto = (TextView) convertView.findViewById(R.id.txtProdutos);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.sala.setText("Sala: " +userModelArrayList.get(position).getSala());
        holder.funcionario.setText("Funcionário: " +userModelArrayList.get(position).getFuncionario());
        holder.tipo.setText("Tipo de limpeza: " +userModelArrayList.get(position).getTipoLimpeza());
        holder.produto.setText("Produto utilizado: " +userModelArrayList.get(position).getProduto());

        return convertView;
    }

    private class ViewHolder {

        protected TextView sala, funcionario, tipo, produto;
    }

}
