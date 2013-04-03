/* Chris D'Angelo (cd2665@columbia.edu)
 * Xin Du (xd2137@columbia.edu)
 * 
 * example queries
 */

/*
 * What are the names of movies Harrison Ford has been in?
 */

SELECT m.title
FROM movies m, castcrew c, workedin w
WHERE m.mid = w.mid AND w.cid = c.cid AND c.firstname = 'Harrison' AND c.lastname = 'Ford';

/*
 * What movies has Steven Spielberg worked on, and what was his job title?
 */

SELECT m.title, w.jobTitle
FROM movies m, castcrew c, workedin w
WHERE m.mid = w.mid AND w.cid = c.cid AND c.firstname = 'Steven' AND c.lastname = 'Spielberg';

/*
 * What are the names of movies have more than 1 person working for them
 */

SELECT m.title
FROM movies m, workedin w
WHERE m.mid = w.mid
GROUP BY m.mid, m.title
HAVING count (*) > 1;

/*
 * What is the theater name where Annie Hall is playing?
 */

SELECT t.theaterName
FROM theaters t, movies m, playingat p
WHERE t.tid = p.tid AND m.title = 'Annie Hall' AND m.mid = p.mid;

/*
 * What are the names of movies Chris has rated and what did he rate them?
 */

SELECT m.title, r.rating, r.comments
FROM movies m, rated r, users u 
WHERE u.email = r.email AND u.lastname = 'DAngelo' AND u.firstname = 'Chris' AND
	m.mid = r.mid;

/*
 * What are the names of 'adventure' movies playing in the future? At what theater and time?
 */

SELECT m.title, p.perfDateTime, t.theaterName
FROM movies m, playingat p, theaters t, typeof tp
WHERE m.mid = p.mid AND p.perfDateTime > CURRENT_TIMESTAMP AND t.tid = p.tid AND
	tp.genreName = 'Adventure' AND tp.mid = m.mid;


/*
 * Who are friends of hc2361@columbia.edu?
 */

SELECT f.friendsBEmail 
FROM friendswith f
WHERE f.friendsAEmail = 'hc2361@columbia.edu'
UNION
	SELECT f1.friendsAEmail 
	FROM friendswith f1
	WHERE f1.friendsBEmail = 'hc2361@columbia.edu';


/*
 * When is Star Wars rental service available and how much is it?
 */

 SELECT r.availFrom, r.availTo, r.price
 FROM rentavailablefrom r, movies m
 WHERE m.mid = r.mid and m.title = 'Star Wars';

/*
* Find all the quotes content in Casablanca
*/

SELECT q.characterName, q.quote
FROM quotes q, movies m
Where m.mid =q.mid and m.title = 'Casablanca';


/*
* Find all the movies watched by user duxin29@gmail.com
*/

SELECT m.title
FROM watched w, movies m
WHERE m.mid = w.mid and w.email = 'duxin29@gmail.com';

/*
 * Find movies that are both Sci-Fi and Adventure. 
 */

SELECT m.title
FROM typeof t, movies m
WHERE t.mid = m.mid AND t.genreName = 'Sci-Fi' AND t.mid IN (
	SELECT m2.mid
	FROM typeof t2, movies m2
	WHERE t2.mid = m2.mid AND t2.genreName = 'Adventure');