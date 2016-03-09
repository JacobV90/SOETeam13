/* See LICENSE for licensing and NOTICE for copyright. */
package org.passay;

import java.util.ArrayList;
import java.util.List;
import org.cryptacular.bean.EncodingHashBean;
import org.cryptacular.spec.CodecSpec;
import org.cryptacular.spec.DigestSpec;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

/**
 * Unit test for {@link DigestHistoryRule}.
 *
 * @author  Middleware Services
 */
public class DigestHistoryRuleTest extends AbstractRuleTest
{

  /** Test password. */
  private static final String VALID_PASS = "t3stUs3r00";

  /** Test password. */
  private static final String HISTORY_PASS1 = "t3stUs3r01";

  /** Test password. */
  private static final String HISTORY_PASS2 = "t3stUs3r02";

  /** Test password. */
  private static final String HISTORY_PASS3 = "t3stUs3r03";

  /** Test username. */
  private static final String USER = "testuser";

  /** For testing. */
  private final List<PasswordData.Reference> digestRefs = new ArrayList<>();

  /** For testing. */
  private final List<PasswordData.Reference> saltedDigestRefs = new ArrayList<>();

  /** For testing. */
  private final DigestHistoryRule digestRule = new DigestHistoryRule(
    new EncodingHashBean(new CodecSpec("Base64"), new DigestSpec("SHA1"), 1, false));

  /** For testing. */
  private final DigestHistoryRule saltedDigestRule = new DigestHistoryRule(
    new EncodingHashBean(new CodecSpec("Base64"), new DigestSpec("SHA1"), 1, false));

  /** For testing. */
  private final DigestHistoryRule emptyDigestRule = new DigestHistoryRule(
    new EncodingHashBean(new CodecSpec("Base64"), new DigestSpec("SHA1"), 1, false));


  /** Initialize rules for this test. */
  @BeforeClass(groups = {"passtest"})
  public void createRules()
  {
    digestRefs.add(new PasswordData.HistoricalReference("history", "safx/LW8+SsSy/o3PmCNy4VEm5s="));
    digestRefs.add(new PasswordData.HistoricalReference("history", "zurb9DyQ5nooY1la8h86Bh0n1iw="));
    digestRefs.add(new PasswordData.HistoricalReference("history", "bhqabXwE3S8E6xNJfX/d76MFOCs="));

    saltedDigestRefs.add(new PasswordData.HistoricalReference("salted-history", "2DSZvOzGiMnm/Mbxt1M3zNAh7P1GebLG"));
    saltedDigestRefs.add(new PasswordData.HistoricalReference("salted-history", "rv1mF2DuarrF//LPP9+AFJal8bMc9G5z"));
    saltedDigestRefs.add(new PasswordData.HistoricalReference("salted-history", "3lABdWxtWhfGKtXBx4MfiWZ1737KnFuG"));
  }


  /**
   * @return  Test data.
   *
   * @throws  Exception  On test data generation failure.
   */
  @DataProvider(name = "passwords")
  public Object[][] passwords()
    throws Exception
  {
    return
      new Object[][] {

        {
          digestRule,
          PasswordData.newInstance(VALID_PASS, USER, digestRefs),
          null,
        },
        {
          digestRule,
          PasswordData.newInstance(HISTORY_PASS1, USER, digestRefs),
          codes(HistoryRule.ERROR_CODE),
        },
        {
          digestRule,
          PasswordData.newInstance(HISTORY_PASS2, USER, digestRefs),
          codes(HistoryRule.ERROR_CODE),
        },
        {
          digestRule,
          PasswordData.newInstance(HISTORY_PASS3, USER, digestRefs),
          codes(HistoryRule.ERROR_CODE),
        },

        {
          saltedDigestRule,
          PasswordData.newInstance(VALID_PASS, USER, saltedDigestRefs),
          null,
        },
        {
          saltedDigestRule,
          PasswordData.newInstance(HISTORY_PASS1, USER, saltedDigestRefs),
          codes(HistoryRule.ERROR_CODE),
        },
        {
          saltedDigestRule,
          PasswordData.newInstance(HISTORY_PASS2, USER, saltedDigestRefs),
          codes(HistoryRule.ERROR_CODE),
        },
        {
          saltedDigestRule,
          PasswordData.newInstance(HISTORY_PASS3, USER, saltedDigestRefs),
          codes(HistoryRule.ERROR_CODE),
        },

        {
          emptyDigestRule,
          PasswordData.newInstance(VALID_PASS, USER, null),
          null,
        },
        {
          emptyDigestRule,
          PasswordData.newInstance(HISTORY_PASS1, USER, null),
          null,
        },
        {
          emptyDigestRule,
          PasswordData.newInstance(HISTORY_PASS2, USER, null),
          null,
        },
        {
          emptyDigestRule,
          PasswordData.newInstance(HISTORY_PASS3, USER, null),
          null,
        },
      };
  }


  /**
   * @return  Test data.
   *
   * @throws  Exception  On test data generation failure.
   */
  @DataProvider(name = "messages")
  public Object[][] messages()
    throws Exception
  {
    return
      new Object[][] {
        {
          digestRule,
          PasswordData.newInstance(HISTORY_PASS1, USER, digestRefs),
          new String[] {String.format("Password matches one of %s previous passwords.", digestRefs.size()), },
        },
      };
  }
}
