/* Chris D'Angelo (cd2665@columbia.edu)
 * Xin Du (xd2137@columbia.edu)
 *
 * 3/20/13
 * Project 1.2 - Database Setup
 * 
 */

CREATE TABLE movies (
	mid INTEGER,
	title VARCHAR2(100),
	synopsis VARCHAR2(2000),
	runningTime VARCHAR2(40),
	country VARCHAR2(40),
	language VARCHAR2(40),
	releaseDate DATE,
	CONSTRAINT movies_pk PRIMARY KEY (mid));

CREATE TABLE theaters (
	tid INTEGER,
	theaterName VARCHAR2(100),
	address VARCHAR2(100),
	city VARCHAR2(40),
	state VARCHAR2(20),
	zip INTEGER,
	CONSTRAINT theaters_pk PRIMARY KEY (tid));

CREATE TABLE rentalservice (
	rid INTEGER,
	serviceName VARCHAR2(40),
	sURL VARCHAR2(100),
	address VARCHAR2(100),
	city VARCHAR2(40),
	state VARCHAR2(20),
	zip INTEGER,
	description VARCHAR2(2000),
	CONSTRAINT rentalservice_pk PRIMARY KEY (rid));

CREATE TABLE castcrew (
	cid INTEGER,
	lastname VARCHAR2(40),
	firstname VARCHAR2(40),
	gender VARCHAR2(20),
	dob DATE,
	trivia VARCHAR2(2000),
	CONSTRAINT castcrew_pk PRIMARY KEY (cid));

CREATE TABLE quotes (
	qid INTEGER,
	characterName VARCHAR2(40),
	quote VARCHAR2(2000),
	mid INTEGER NOT NULL,
	CONSTRAINT quotes_pk PRIMARY KEY (qid),
	CONSTRAINT quotes_mid_fk FOREIGN KEY (mid) REFERENCES movies
		ON DELETE CASCADE);

CREATE TABLE genres (
	genreName VARCHAR2(20),
	CONSTRAINT genres_pk PRIMARY KEY (genreName));

CREATE TABLE users (
	email VARCHAR2(40),
	firstname VARCHAR2(40),
	lastname VARCHAR2(40),
	Password VARCHAR2 (20),
	CONSTRAINT users_pk PRIMARY KEY (email));

CREATE TABLE playingat (
	perfDateTime TIMESTAMP,
	tid INTEGER,
	mid INTEGER,
	CONSTRAINT playingat_pk PRIMARY KEY (tid, perfDateTime),
	CONSTRAINT playingat_mid_fk FOREIGN KEY (mid) REFERENCES movies
			ON DELETE CASCADE,
	CONSTRAINT playingat_tid_fk FOREIGN KEY (tid) REFERENCES theaters
	        ON DELETE CASCADE);

CREATE TABLE rentavailablefrom (
	availFrom DATE,
	availTo DATE,
	price REAL,
	directurl VARCHAR2(100),
	priceQty VARCHAR2(100),
	terms VARCHAR2(2000),
	rid INTEGER,
	mid INTEGER,
	CONSTRAINT rentavailablefrom_pk PRIMARY KEY (rid, mid, availFrom, availTo),
	CONSTRAINT rentavailablefrom_mid_fk FOREIGN KEY (mid) REFERENCES movies,
	CONSTRAINT rentavailablefrom_rid_fk FOREIGN KEY (rid) REFERENCES rentalservice
	        ON DELETE CASCADE,
	CONSTRAINT rentavailablefrom_validDates CHECK (availTo > availFrom));

CREATE TABLE rated (
	rating REAL,
	comments VARCHAR2(2000),
	ratedDate DATE,
	mid INTEGER,
	email VARCHAR2(40),
	CONSTRAINT rated_pk PRIMARY KEY (mid, email),
	CONSTRAINT rated_mid_fk FOREIGN KEY (mid) REFERENCES movies
	        ON DELETE CASCADE,
	CONSTRAINT rated_email_fk FOREIGN KEY (email) REFERENCES users
	        ON DELETE CASCADE,
	CONSTRAINT rated_validBounds CHECK (rating >= 1.0 AND rating <= 10.0));

CREATE TABLE watched (
	watchedDate DATE,
	mid INTEGER,
	email VARCHAR2(40),
	CONSTRAINT watched_mid_fk FOREIGN KEY (mid) REFERENCES movies
		ON DELETE CASCADE,
	CONSTRAINT watched_email_fk FOREIGN KEY (email) REFERENCES users
	        ON DELETE CASCADE);

CREATE TABLE workedin (
	characterName VARCHAR2(100),
	jobCategory VARCHAR2(100),
	billingNum INTEGER,
	jobTitle VARCHAR2(20),
	mid INTEGER,
	cid INTEGER,
	CONSTRAINT workedin_mid_fk FOREIGN KEY (mid) REFERENCES movies
		ON DELETE CASCADE,
	CONSTRAINT workedin_cid_fk FOREIGN KEY (cid) REFERENCES castcrew);

CREATE TABLE typeof (
	mid INTEGER,
	genreName VARCHAR2(20),
	CONSTRAINT typeof_pk PRIMARY KEY (mid, genreName),
	CONSTRAINT typeof_mid_fk FOREIGN KEY (mid) REFERENCES movies
		ON DELETE CASCADE,
	CONSTRAINT typeof_genreName_fk FOREIGN KEY (genreName) REFERENCES genres);

CREATE TABLE castcrewrated (
	rating REAL,
	ratedDate DATE,
	cid INTEGER,
	email VARCHAR2(40),
	CONSTRAINT castcrewrated_pk PRIMARY KEY (cid, email),
	CONSTRAINT castcrewrated_cid_fk FOREIGN KEY (cid) REFERENCES castcrew
		ON DELETE CASCADE,
	CONSTRAINT castcrewrated_email_fk FOREIGN KEY (email) REFERENCES users
	        ON DELETE CASCADE,
	CONSTRAINT castcrewrated_validBounds CHECK (rating >= 1.0 AND rating <= 10.0));

CREATE TABLE friendswith (
	friendsAEmail VARCHAR2(40),
	friendsBEmail VARCHAR2(40),
	CONSTRAINT friendswith_pk PRIMARY KEY (friendsAEmail, friendsBEmail),
	CONSTRAINT friendswith_friendsAEmail_fk FOREIGN KEY (friendsAEmail) REFERENCES users(email)
		ON DELETE CASCADE,
	CONSTRAINT friendswith_friendsBEmail_fk FOREIGN KEY (friendsBEmail) REFERENCES users(email)
		ON DELETE CASCADE,
	CONSTRAINT friendswith_cantFriendSelf CHECK (friendsAEmail <> friendsBEmail));
