# chuckjokes
Chuck Norris Jokes API
This is a Java-based REST API that returns random Chuck Norris jokes. The API has one endpoint:

/api/jokes/random
Returns a random Chuck Norris joke in JSON format.

Example response:

json
Copy code
{
"id": 1,
"joke": "Chuck Norris doesn't actually write books, the words assemble themselves out of fear."
}
To use the API, simply send a GET request to the endpoint. The response will contain a randomly selected joke, with the id field indicating the unique identifier of the joke.

This API is built using the Spring Boot framework and retrieves the jokes from a text file located in the resources folder.
