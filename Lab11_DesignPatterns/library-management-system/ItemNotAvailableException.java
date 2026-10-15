public class ItemNotAvailableException extends Exception {

    private final String itemId;

    public ItemNotAvailableException(String itemId, String title) {
        super("Item " + itemId + " (" + title + ") is already on loan");
        this.itemId = itemId;
    }

    public String getItemId() { return itemId; }
}
