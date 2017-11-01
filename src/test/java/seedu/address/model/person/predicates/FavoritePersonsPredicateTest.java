package seedu.address.model.person.predicates;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FavoritePersonsPredicateTest {

    @Test
    public void test_equal() {
        String firstPredicateKeyword = "favorite";
        String secondPredicateKeyword = "unfavorite";

        FavoritePersonsPredicate firstPredicate = new FavoritePersonsPredicate(firstPredicateKeyword);
        FavoritePersonsPredicate secondPredicate = new FavoritePersonsPredicate(secondPredicateKeyword);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        FavoritePersonsPredicate firstPredicateCopy = new FavoritePersonsPredicate(firstPredicateKeyword);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_() {

    }
}
