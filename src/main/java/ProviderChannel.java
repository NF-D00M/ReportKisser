public class ProviderChannel implements Channel{
    private String ProviderName;
    @Override
    public void update(String providerName) {
        this.SetProviderName(providerName);
    }

    public void SetProviderName(String providerName) {
        this.ProviderName = providerName;
    }
}
