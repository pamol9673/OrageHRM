package api_tests;

import api_config.API_config;
import api_models.Post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Post_API_Tests {

	private String baseUrl;

	@BeforeClass
	public void setup() {
		baseUrl = API_config.getBaseUrl();
		baseURI = baseUrl;
		System.out.println("Base URL configured: " + baseUrl);

		// Optional: Print config for verification
		API_config.printConfig();
	}

	/**
	 * TEST 1: Successful request - Create a new post Validates: Status code 201 and
	 * response fields
	 */
	@Test(priority = 1, description = "Create a new post successfully")
	public void testCreatePostSuccess() {
		System.out.println("\n=== Test 1: Create Post Success ===");

		Post newPost = new Post(1001, "Q4 Financial Report", "Revenue increased by 25% year-over-year");

		Response response = given().contentType(ContentType.JSON).body(newPost).when().post("/posts").then()
				.statusCode(201) // Validate status code
				.body("userId", equalTo(1001)).body("title", equalTo("Q4 Financial Report"))
				.body("body", equalTo("Revenue increased by 25% year-over-year")).body("id", notNullValue())
				.body("id", instanceOf(Integer.class)).extract().response();

		// Deserialize response to POJO for additional validation
		Post createdPost = response.as(Post.class);
		assertThat(createdPost.getUserId(), is(1001));
		assertThat(createdPost.getTitle(), is("Q4 Financial Report"));
		assertThat(createdPost.getId(), greaterThan(0));

		System.out.println("✅ Successfully created post with ID: " + createdPost.getId());
		System.out.println("Response: " + response.asString());
	}

	/**
	 * TEST 2: Failure case - Get non-existent post Validates: 404 Not Found status
	 */
	@Test(priority = 2, description = "Get non-existent post returns 404")
	public void testGetNonExistentPostFailure() {
		System.out.println("\n=== Test 2: Failure Case - Non-existent Post ===");

		given().pathParam("id", 999999).when().get("/posts/{id}").then().statusCode(404).log().ifError(); // Log only if
																											// error
																											// occurs

		System.out.println("✅ Got 404 status for non-existent post as expected");
	}

	/**
	 * TEST 3: Additional failure case - Invalid endpoint
	 */
	@Test(priority = 3, description = "Invalid endpoint returns 404")
	public void testInvalidEndpoint() {
		System.out.println("\n=== Test 3: Failure Case - Invalid Endpoint ===");

		given().when().get("/invalid_endpoint_12345").then().statusCode(404);

		System.out.println("✅ Got 404 for invalid endpoint");
	}

	/**
	 * TEST 4: Get and validate existing post
	 */
	@Test(priority = 4, description = "Get existing post and validate fields")
	public void testGetExistingPost() {
		System.out.println("\n=== Test 4: Get Existing Post ===");

		given().pathParam("id", 1).when().get("/posts/{id}").then().statusCode(200).body("id", equalTo(1))
				.body("userId", notNullValue()).body("title", notNullValue()).body("body", notNullValue()).log()
				.ifValidationFails();

		System.out.println("✅ Successfully retrieved post with ID 1");
	}
}
