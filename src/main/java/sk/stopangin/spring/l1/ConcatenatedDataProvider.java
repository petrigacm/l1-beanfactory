package sk.stopangin.spring.l1;

public class ConcatenatedDataProvider implements DataProvider {
    @Override
    public Data getData() {
        return new Data("tsd");
    }
}
