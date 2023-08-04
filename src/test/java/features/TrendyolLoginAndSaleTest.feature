@TrendyolLoginAndSaleTest
  Feature: Trendyol Login and Sale Test

    @TrendyolLoginSuccessAndSale
    Scenario Outline: Success Login Process
      Given Go to Website "<url>"
      And Accept "<cookieAcceptPath>" or Reject "<cookieRejectPath>" Cookies
      And Click Login Button "<loginButtonPath>"
      And Fill in Username Field "<userNamePath>" "<userName>"
      And Fill in Password Field "<passwordPath>" "<password>"
      When Click Login Button "<loginAcceptButtonPath>"
      And Select Input Button "<selectInputButtonPath>" "<inputMessage>" and Click Search Button "<searchButtonPath>"
      And Choose Brand "<chooseBrandButtonPath>"
      And Click to Product "<productPath>"
      And Add "<addToCartButtonPath>" and Go to the Cart "<goToCartButtonPath>"
      And Click to Understand Button
      And Empty the Basket "<deleteButtonPath>"
      Examples:
        |           url             |                cookieAcceptPath            |      cookieRejectPath      |          loginButtonPath          |         userNamePath       |           userName           |            passwordPath            |  password  |                    loginAcceptButtonPath                     |                          selectInputButtonPath                         | inputMessage |    searchButtonPath    |        chooseBrandButtonPath         |                                productPath                                                                                                |             addToCartButtonPath           |      goToCartButtonPath        |    deleteButtonPath   |
        | https://www.trendyol.com/ |//button[@id='onetrust-accept-btn-handler'] | //a[@id='rejectAllButton'] | //p[contains(text(),'Giriş Yap')] | //input[@id='login-email'] | testautomationexam@gmail.com| //input[@id='login-password-input']|Mehmet1234 | //button[@type='submit']//span[contains(text(),'Giriş Yap')] | //input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız'] | airpods    | //i[@class='cyrzo7gC'] | //div[contains(text(),'Apple')] | //a[@href='/apple/airpods-pro-magsafe-sarj-kutusu-turkiye-garantili-mlwk3tu-a-p-182350529?boutiqueId=613360&merchantId=107032'] | //div[@class='add-to-basket-button-text'] | //a[@class='go-basket-button'] | //i[@class='i-trash'] |


    @TrendyolLoginFail
    Scenario Outline: Fail Login Process
      Given Go to Website "<url>"
      And Accept "<cookieAcceptPath>" or Reject "<cookieRejectPath>" Cookies
      And Click Login Button "<loginButtonPath>"
      And Fill in Username Field "<userNamePath>" "<userName>"
      And Fill in Password Field "<passwordPath>" "<password>"
      When Click Login Button "<loginAcceptButtonPath>"
      Then Check Error Message "<messagePath>"
      Examples:
        |             url           |               cookieAcceptPath              |       cookieRejectPath     |         loginButtonPath           |        userNamePath        |            userName          |            passwordPath            | password |                   loginAcceptButtonPath                      |                 messagePath                 |
        | https://www.trendyol.com/ | //button[@id='onetrust-accept-btn-handler'] | //a[@id='rejectAllButton'] | //p[contains(text(),'Giriş Yap')] | //input[@id='login-email'] | testautomationexam@gmail.com | //input[@id='login-password-input']| Mehmet12 | //button[@type='submit']//span[contains(text(),'Giriş Yap')] | /html[1]/body[1]/div[1]/div[3]/div[3]/div[1]|