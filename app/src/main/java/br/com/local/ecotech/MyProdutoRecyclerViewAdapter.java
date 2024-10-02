package br.com.local.ecotech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Switch;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import br.com.local.ecotech.ProdutoFragment.OnListFragmentInteractionListener;
import br.com.local.ecotech.placeholder.ProdutoContent.ProdutoItem;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProdutoRecyclerViewAdapter extends
        RecyclerView.Adapter<MyProdutoRecyclerViewAdapter.ViewHolder> {

    private final List<ProdutoItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyProdutoRecyclerViewAdapter(List<ProdutoItem> items,
                                        OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int
            position) {
        holder.mItem = mValues.get(position);
        holder.mCodigoView.setText(mValues.get(position).codigo);

        holder.mDescricaoView.setText(mValues.get(position).descricao);
        holder.mQtdeView.setText(mValues.get(position).qtde);
               holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (th activity, if the fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mValues.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatTextView mCodigoView;
        public final AppCompatTextView mDescricaoView;
        public final AppCompatButton mQtdeView;
        public final AppCompatImageButton mValorView;
        public ProdutoItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCodigoView = (AppCompatTextView)
                    view.findViewById(R.id.nome);
            mDescricaoView = (AppCompatTextView)
                    view.findViewById(R.id.bairro);
            mQtdeView = (AppCompatButton)
                    view.findViewById(R.id.view_details);
            mValorView = (AppCompatImageButton)
                    view.findViewById(R.id.imagem_perfil);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + mDescricaoView.getText()
                    + "'";

        }
    }
}