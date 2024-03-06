package Providers;

public class ProviderFactory {
    public Provider getProvider(String providerType) {
        if (providerType == null) {
            return null;
        }
        if (providerType.equalsIgnoreCase("HRV")) {
            return new HRV("HRV");
        }
        else if (providerType.equalsIgnoreCase("GRV")) {
//            return new GRV("GRV");
        }
        return null;
    }

}
