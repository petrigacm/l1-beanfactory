package sk.stopangin.spring.l1;

public class FullDataProvider implements DataProvider {
    @Override
    public Data getData() {
        return new Data("toto su plne data");
    }
}
