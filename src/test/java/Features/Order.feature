@tag
Feature: Purchase order from ecommerce site

	Background:
	Given: User is on ecommerce site

  @tag1
  Scenario: Add Product to cart
  Given User logged in ecommerce site with username
    When User is on product page and User click on add to cart button for products
    Then products are added in cart
  
   