package ${packageName}.api;

public interface OnItemClickListener<V> {
    
    void onItemClick(V itemValue, int viewID, int position);
}
