package com.testes.automatizados.testesautomatizados;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class LeilaoMatcher extends TypeSafeMatcher<Leilao> {

    private final Lance lance;

    public LeilaoMatcher(Lance lance) {
        this.lance = lance;
    }

    public static Matcher<Leilao> temUmLance(Lance lance) {
        return new LeilaoMatcher(lance);
    }

    @Override
    protected boolean matchesSafely(Leilao item) {
        return item.getLances().contains(lance);
    }

    @Override
    public void describeTo(Description descricao) {
        descricao.appendText("leilao com lance " + lance.getValor());
    }
}
