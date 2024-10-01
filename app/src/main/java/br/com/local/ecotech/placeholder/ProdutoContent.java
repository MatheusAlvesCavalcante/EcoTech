package br.com.local.ecotech.placeholder;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */

public class ProdutoContent {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<ProdutoItem> ITEMS = new
            ArrayList<ProdutoItem>();
    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ProdutoItem> ITEM_MAP = new
            HashMap<String, ProdutoItem>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createProdutoItem(i));
        }
    }

    private static void addItem(ProdutoItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.codigo, item);
    }

    private static ProdutoItem createProdutoItem(int position) {
        return new ProdutoItem(String.valueOf(position), "Produto " +
                position, makeDetails(position), null, null);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Detalhes sobre o produto: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMais informações sobre o produto.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ProdutoItem {
        public final String codigo;
        public final String descricao;
        public final String qtde;
        public final String valor_unit;
        public final String status;

        public ProdutoItem(String codigo, String descricao, String
                qtde, String valor_unit, String status) {
            this.codigo = codigo;
            this.descricao = descricao;
            this.qtde = qtde;
            this.valor_unit = valor_unit;
            this.status = status;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }
}
