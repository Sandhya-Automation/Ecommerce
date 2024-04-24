Feature:Login to the application, search for an item and submit the order

  Background:
    Given I landed on the ecommerce page
  @SubmitOrder
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When search for the product <productName> from the list and add to cart
    And checkout <productName> and submit the order
    Then Verify the item in orders and orderid

    Examples:
      |name         | password| productName|
      |sandhyavg@gmail.com | Queen@1234| IPhone 13 pro |
#      |anshika@gmail.com   |Iamking@000| Adidas Original|