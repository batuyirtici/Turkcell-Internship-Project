@AmazonLoginAndSaleTest
  Feature: Amazon Login and Sale Test

    @AmazonLoginSuccessAndSale
    Scenario Outline: Success Login Process
      Given Go to Website "<url>"
      And Accept "<cookieAcceptPath>" or Reject "<cookieRejectPath>" Cookies
      And Click Login Button "<loginButtonPath>"
      And Fill in Username Field "<userNamePath>" "<userName>"
      And Click Login Button "<continueButtonPath>"
      And Fill in Password Field "<passwordPath>" "<password>"
      When Click Login Button "<loginAcceptButtonPath>"
      And Select Input Button "<selectInputButtonPath>" "<inputMessage>" and Click Search Button "<searchButtonPath>"
      And Click Shipped by Amazon
      And Choose Brand "<chooseBrandButtonPath>"
      And Click to Product "<productPath>"
      And Add "<addToCartButtonPath>" and Go to Cart "<goToCartButtonPath>"
      And Empty the Basket "<deleteButtonPath>"
      Examples:
        |             url            |       cookieAcceptPath      |         cookieRejectPath        |                 loginButtonPath               |       userNamePath      |            userName          |   continueButtonPath    |         passwordPath       |  password  |    loginAcceptButtonPath    |       selectInputButtonPath        | inputMessage |             searchButtonPath            |                    chooseBrandButtonPath                   |                                   productPath                                |          addToCartButtonPath        |        goToCartButtonPath      |    deleteButtonPath   |
        | https://www.amazon.com.tr/ | //input[@id='sp-cc-accept'] | //a[@id='sp-cc-rejectall-link'] | //span[@id='nav-link-accountList-nav-line-1'] | //input[@id='ap_email'] | testautomationexam@gmail.com | //input[@id='continue'] | //input[@id='ap_password'] | Mehmet1234 | //input[@id='signInSubmit'] | //input[@id='twotabsearchtextbox'] |    airpods   | //input[@id='nav-search-submit-button'] | //li[@id='p_89/Apple']//i[@class='a-icon a-icon-checkbox'] | //img[@src='https://m.media-amazon.com/images/I/61p2QS1squL._AC_UL400_.jpg'] | //input[@name='submit.add-to-cart'] | //a[@href='/cart?ref_=sw_gtc'] | //input[@value='Sil'] |


    @AmazonLoginFail
    Scenario Outline: Fail Login Process
      Given Go to Website "<url>"
      And Accept "<cookieAcceptPath>" or Reject "<cookieRejectPath>" Cookies
      And Click Login Button "<loginButtonPath>"
      And Fill in Username Field "<userNamePath>" "<userName>"
      And Click Login Button "<continueButtonPath>"
      And Fill in Password Field "<passwordPath>" "<password>"
      When Click Login Button "<loginAcceptButtonPath>"
      Then Check Error Message "<messagePath>"
      Examples:
        |             url            |       cookieAcceptPath      |         cookieRejectPath        |                 loginButtonPath               |       userNamePath      |            userName          |   continueButtonPath    |         passwordPath       | password |    loginAcceptButtonPath    |                  messagePath              |
        | https://www.amazon.com.tr/ | //input[@id='sp-cc-accept'] | //a[@id='sp-cc-rejectall-link'] | //span[@id='nav-link-accountList-nav-line-1'] | //input[@id='ap_email'] | testautomationexam@gmail.com | //input[@id='continue'] | //input[@id='ap_password'] | Mehmet12 | //input[@id='signInSubmit'] | //h4[contains(text(),'Bir sorun oluştu')] |