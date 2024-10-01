package br.com.local.ecotech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Switch;
import br.com.local.ecotech.ProdutoFragment.OnListFragmentInteractionListener;
import br.com.local.ecotech.placeholder.ProdutoContent.ProdutoItem;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProdutoRecyclerViewAdapter extends
        RecyclerView.Adapter<MyProdutoRecyclerViewAdapter.ViewHolder> {

    public MyProdutoRecyclerViewAdapter(List<ProdutoItem> items,
                                        OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_produto, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int
            position) {
        holder.mItem = mValues.get(position);
        holder.mCodigoView.setText(mValues.get(position).codigo);

        holder.mDescricaoView.setText(mValues.get(position).descricao);
        holder.mQtdeView.setText(mValues.get(position).qtde);
        holder.mValorView.setText(mValues.get(position).valor_unit);
        holder.mStatusView.setChecked(true);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the
                    activity, if the
                    // fragment is attached to one) that an item has
                    been selected.
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
        public final TextView mCodigoView;
        public final TextView mDescricaoView;
        public final TextView mQtdeView;
        public final TextView mValorView;
        public final Switch mStatusView;
        public ProdutoItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCodigoView = (TextView)
                    view.findViewById(R.id.codigo_produto);
            mDescricaoView = (TextView)
                    view.findViewById(R.id.descricao_produto);
            mQtdeView = (TextView)
                    view.findViewById(R.id.quantidade_produto);
            mValorView = (TextView)
                    view.findViewById(R.id.valor_produto);
            mStatusView = (Switch)
                    view.findViewById(R.id.status_produto);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + mDescricaoView.getText()
                    + "'";

        }
    }
}