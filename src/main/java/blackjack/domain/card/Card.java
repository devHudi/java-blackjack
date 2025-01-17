package blackjack.domain.card;

import blackjack.domain.game.Score;
import java.util.HashSet;
import java.util.Set;

public class Card {
    private static final String TO_STRING_FORMAT = "Card{%s%s}";
    private final CardRank rank;
    private final CardSymbol symbol;

    private Card(CardRank rank, CardSymbol symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public static Card of(CardRank rank, CardSymbol symbol) {
        return CardCache.getCache(rank, symbol);
    }

    public Score getRankValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,
                rank.getDisplayName(), symbol.getDisplayName());
    }

    private static class CardCache {
        static Set<Card> cache = new HashSet<>();

        static Card getCache(CardRank rank, CardSymbol symbol) {
            return cache.stream()
                    .filter(card -> card.rank == rank)
                    .filter(card -> card.symbol == symbol)
                    .findAny()
                    .orElseGet(() -> createNewCache(rank, symbol));
        }

        static Card createNewCache(CardRank rank, CardSymbol symbol) {
            Card newCard = new Card(rank, symbol);
            cache.add(newCard);

            return newCard;
        }
    }
}
