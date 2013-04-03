/*
 * Movies
 */

INSERT INTO movies VALUES (
	1, 
	'Annie Hall', 
	'Neurotic New York comedian Alvy Singer falls in love with the ditsy Annie Hall.', 
	'93 min', 
	'USA', 
	'English', 
	(to_date('1977/04/20 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	2, 
	'Jurassic Park', 
	'During a preview tour a theme park suffers a major power breakdown that allows its cloned dinosaur exhibits to run amok.', 
	'127 min', 
	'USA', 
	'English', 
	(to_date('1993/06/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	3, 
	'Star Wars', 
	'Luke Skywalker, a spirited farm boy, joins rebel forces to save Princess Leia from the evil Darth Vader, and the galaxy from the Empires planet-destroying Death Star.',
	'121 min', 
	'USA', 
	'English', 
	(to_date('1977/05/25 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	4, 
	'Star Wars: Episode V - The Empire Strikes Back', 
	'As Luke trains with Master Yoda to become a Jedi Knight, his friends evade the Imperial fleet under the command of Darth Vader who is obsessed with turning Skywalker to the Dark Side of the Force.', 
	'124 min', 
	'USA', 
	'English', 
	(to_date('1980/05/21 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	5, 
	'Who Framed Roger Rabbit', 
	'A toon hating detective is a cartoon rabbits only hope to prove his innocence when he is accused of murder.',
	'104 min', 
	'USA', 
	'English', 
	(to_date('1988/06/22 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	6, 
	'Back to the Future',
	'A teenager is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his friend, Dr. Emmett Brown, and must make sure his high-school-age parents unite in order to save his own existence.',
	'116 min', 
	'USA', 
	'English', 
	(to_date('1985/07/03 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	7, 
	'Back to the Future Part II',
	'After visiting 2015, Marty McFly must repeat his visit to 1955 to prevent disastrous changes to 1985... without interfering with his first trip.',
	'108 min', 
	'USA', 
	'English', 
	(to_date('1989/11/22 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	8, 
	'Raiders of the Lost Ark',
	'Archeologist and adventurer Indiana Jones is hired by the US government to find the Ark of the Covenant before the Nazis.',
	'115 min', 
	'USA', 
	'English', 
	(to_date('1981/06/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	9, 
	'Indiana Jones and the Last Crusade',
	'When Dr. Henry Jones Sr. suddenly goes missing while pursuing the Holy Grail, eminent archaeologist Indiana Jones must follow in his fathers footsteps and stop the Nazis.',
	'127 min', 
	'USA', 
	'English', 
	(to_date('1989/05/24 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

INSERT INTO movies VALUES (
	10, 
	'Casablanca',
	'Set in unoccupied Africa during the early days of World War II: An American expatriate meets a former lover, with unforeseen complications.',
	'102 min', 
	'USA', 
	'English', 
	(to_date('1943/01/23 00:00:00', 'yyyy/mm/dd hh24:mi:ss')));

/*
 * Theaters
 */

INSERT INTO theaters VALUES (
	100, 
	'Regal E-Walk 13', 
	'247 W 42nd St', 
	'New York', 
	'NY', 
	'10036');

INSERT INTO theaters VALUES (
	101, 
	'AMC Empire 25', 
	'234 West 42nd St.', 
	'New York', 
	'NY', 
	'10036');

INSERT INTO theaters VALUES (
	102, 
	'AMC Loews 34th Street 14', 
	'312 W. 34th St.', 
	'New York', 
	'NY', 
	'10001');

INSERT INTO theaters VALUES (
	103, 
	'Clearviews Ziegfeld', 
	'141 West 54th Street', 
	'New York', 
	'NY', 
	'10019');

INSERT INTO theaters VALUES (
	104, 
	'Lincoln Plaza Cinemas', 
	'1886 Broadway', 
	'New York', 
	'NY', 
	'10023');

INSERT INTO theaters VALUES (
	105, 
	'Clearviews Chelsea', 
	'141 West 54th Street', 
	'New York', 
	'NY', 
	'10019');

INSERT INTO theaters VALUES (
	106, 
	'Clearviews Ziegfeld', 
	'260 West 23rd Street', 
	'New York', 
	'NY', 
	'10011');

INSERT INTO theaters VALUES (
	107, 
	'Museum Of Modern Art (MOMA)', 
	'11 West 53rd Street', 
	'New York', 
	'NY', 
	'10019');

INSERT INTO theaters VALUES (
	108, 
	'Film Society Lincoln Center - Walter Reade Theater', 
	'165 West 65th Street', 
	'New York', 
	'NY', 
	'10023');

INSERT INTO theaters VALUES (
	109, 
	'Film Society Lincoln Center - Elinor Bunin Munroe Film Center', 
	'144 West 65th Street', 
	'New York', 
	'NY', 
	'10133');

/*
 * Rental Services
 */


INSERT INTO rentalservice VALUES (
	1000, 
	'Netflix', 
	'http://movies.netflix.com', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'Netflix, Inc. is an American provider of on-demand Internet streaming media available to both North and South America, the Caribbean, United Kingdom, Ireland, Sweden, Denmark, Norway, Finland and flat rate DVD-by-mail in the United States, where mailed DVDs are sent via Permit Reply Mail.');

INSERT INTO rentalservice VALUES (
	1001, 
	'iTunes', 
	'http://www.apple.com/itunes/', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'iTunes is a media player and media library application developed by Apple Inc');

INSERT INTO rentalservice VALUES (
	1002, 
	'Google Play', 
	'https://play.google.com/store', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'Google Play, formerly known as the Android Market, is a digital application distribution platform for Android developed and maintained by Google');


INSERT INTO rentalservice VALUES (
	1003, 
	'vudu', 
	'http://www.vudu.com', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'Vudu, Inc. is a content delivery and media technology company responsible for Vudu-branded interactive media services and devices.');


INSERT INTO rentalservice VALUES (
	1005, 
	'hulu', 
	'http://www.hulu.com', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'Hulu is a website and over-the-top (OTT) subscription service offering ad-supported on-demand streaming video of TV shows, movies, webisodes and other new media, trailers, clips, and behind-the-scenes footage from NBC, Fox, ABC, TBS, and many other networks and studios.');

INSERT INTO rentalservice VALUES (
	1006, 
	'redbox', 
	'http://www.redbox.com', 
	NULL, 
	NULL,
	NULL,
	NULL,
	'Redbox is a subsidiary of Coinstar that specializes in the rental of DVDs, Blu-ray Discs, and video games via automated retail kiosks');

/*
 * Cast and Crew
 */

INSERT INTO castcrew VALUES (
	200, 
	'Ford', 
	'Harrison', 
	'Male',
	(to_date('1942/07/13 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Was a master carpenter before becoming a movie star, a craft he still does as a hobby.');


INSERT INTO castcrew VALUES (
	201, 
	'Fisher', 
	'Carrie', 
	'Female',
	(to_date('1956/10/21 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Checked into substance-abuse program, addiction to prescription drugs.');


INSERT INTO castcrew VALUES (
	202, 
	'Allen', 
	'Woody', 
	'Male',
	(to_date('1935/12/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Speaks French.');

INSERT INTO castcrew VALUES (
	203, 
	'Keaton', 
	'Diane', 
	'Female',
	(to_date('1946/01/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Has adult-onset asthma.');

INSERT INTO castcrew VALUES (
	204, 
	'Bogart', 
	'Humphrey', 
	'Male',
	(to_date('1899/12/25 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Bogarts speech defect (lisping) does not appear in the German dubbings of his voice, which is also lower.');

INSERT INTO castcrew VALUES (
	205, 
	'Goldblum', 
	'Jeff', 
	'Male',
	(to_date('1952/10/22 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Is the voice behind the iMac/iBook commercials for Apple Computer.');

INSERT INTO castcrew VALUES (
	206, 
	'Dern', 
	'Laura', 
	'Female',
	(to_date('1967/02/10 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Once engaged to Jeff Goldblum for two years (1995-1997).');


INSERT INTO castcrew VALUES (
	207, 
	'Spielberg', 
	'Steven', 
	'Male',
	(to_date('1946/12/18 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Consistent references to World War II.');

INSERT INTO castcrew VALUES (
	208, 
	'Fox', 
	'Michael J.', 
	'Male',
	(to_date('1961/06/09 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Revealed in the 7 December 1998 issue of People magazine that he was diagnosed with Parkinsons disease in 1991.');


INSERT INTO castcrew VALUES (
	209, 
	'Lloyd', 
	'Christopher', 
	'Male',
	(to_date('1938/10/22 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Graduate from Staples High School in Westport, Connecticut, in 1958.');

INSERT INTO castcrew VALUES (
	210, 
	'Zemeckis', 
	'Robert', 
	'Male',
	(to_date('1951/05/14 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	'Attended University of Southern California, School of Cinema. Former classmates included George Lucas, John Milius and others.');

/*
 * Quotes
 */


INSERT INTO quotes VALUES (
	301, 
	'Alvy Singer', 
	'Whats with all these awards? Theyre always giving out awards. Best Fascist Dictator: Adolf Hitler.', 
	1);

INSERT INTO quotes VALUES (
	302, 
	'Alvy Singer', 
	'Whats with all these awards? Theyre always giving out awards. Best Fascist Dictator: Adolf Hitler.', 
	1);

INSERT INTO quotes VALUES (
	303, 
	'Alvy Singer', 
	'Honey, theres a spider in your bathroom the size of a Buick.', 
	1);

INSERT INTO quotes VALUES (
	304, 
	'Princess Leia', 
	'Why, you stuck up, half-witted, scruffy-looking Nerf herder.', 
	4);

INSERT INTO quotes VALUES (
	305, 
	'Yoda', 
	'You must unlearn what you have learned.', 
	4);

INSERT INTO quotes VALUES (
	306, 
	'Princess Leia', 
	'You have your moments. Not many of them, but you do have them.', 
	4);

INSERT INTO quotes VALUES (
	307, 
	'Rick', 
	'Tell me, who was it you left me for? Was it Laszlo, or were there others in between? Or - arent you the kind that tells? ', 
	10);

INSERT INTO quotes VALUES (
	308, 
	'Rick', 
	'Im the only cause Im interested in. ', 
	10);

INSERT INTO quotes VALUES (
	309, 
	'Marty McFly', 
	'Jesus, George, it was a wonder I was even born.', 
	6);

INSERT INTO quotes VALUES (
	310, 
	'Marty McFly', 
	'This is heavy.', 
	6);

INSERT INTO quotes VALUES (
	311, 
	'Marty McFly', 
	'Thats Strickland. Jesus didnt that guy ever have hair?', 
	6);

/*
 * Genres
 */

INSERT INTO genres VALUES (
	'Comedy');

INSERT INTO genres VALUES (
	'Drama');

INSERT INTO genres VALUES (
	'Romance');

INSERT INTO genres VALUES (
	'Adventure');

INSERT INTO genres VALUES (
	'Family');

INSERT INTO genres VALUES (
	'Sci-Fi');

INSERT INTO genres VALUES (
	'Action');

INSERT INTO genres VALUES (
	'War');

INSERT INTO genres VALUES (
	'Fantasy');

INSERT INTO genres VALUES (
	'Animation');

INSERT INTO genres VALUES (
	'Crime');

/*
 * users
 */

INSERT INTO users VALUES (
	'chris.dangelo@gmail.com',
	'Chris',
	'DAngelo',
	'password');

INSERT INTO users VALUES (
	'duxin29@gmail.com',
	'Xin',
	'Du',
	'password');

INSERT INTO users VALUES (
	'ab3599@columbia.edu',
	'Abhas',
	'Bodas',
	'password');

INSERT INTO users VALUES (
	'eac2192@columbia.edu',
	'Enrique',
	'Cruz',
	'password');

INSERT INTO users VALUES (
	'hc2361@columbia.edu',
	'Hahn',
	'Chong',
	'password');

INSERT INTO users VALUES (
	'hmg2138@columbia.edu',
	'Harshil',
	'Gandhi',
	'password');

INSERT INTO users VALUES (
	'nx2120@columbia.edu',
	'Ningning',
	'Xia',
	'password');

INSERT INTO users VALUES (
	'zw2219@columbia.edu',
	'Zhiling',
	'Wan',
	'password');

/*
 * playingat
 */

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        100,
        3);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        101,
        4);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        102,
        5);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        103,
        6);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        104,
        7);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        105,
        8);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 10:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        105,
        8);

INSERT INTO playingat VALUES (
        (to_timestamp('2012/02/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        106,
        9);

INSERT INTO playingat VALUES (
        (to_timestamp('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        107,
        10);

INSERT INTO playingat VALUES (
        (to_timestamp('2011/05/06 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        108,
        1);

INSERT INTO playingat VALUES (
        (to_timestamp('2010/02/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        109,
        2);

/*
 * rentavailablefrom
 */
INSERT INTO rentavailablefrom VALUES (
	(to_date('2010/03/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2012/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	99.0,
	'http://www.blockbuster.com/',
	100,
	'two days',
	1000,
	2);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2012/02/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2014/03/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	49.0,
	'http://www.blockbuster.com/',
	100,
	'24 hours',
	1001,
	3);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2000/01/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	99.0,
	NULL,
	150,
	'default term',
	1002,
	4);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2012/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	199.0,
	NULL,
	100,
	'24 hours',
	1003,
	5);

INSERT INTO rentavailablefrom VALUES (
	(to_date('1995/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2005/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	99.0,
	NULL,
	100,
	'1 week',
	1005,
	7);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2001/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2015/08/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	199.0,
	NULL,
	1000,
	'24 hours',
	1006,
	8);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2012/01/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2050/12/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	39.0,
	NULL,
	100,
	'1 week',
	1005,
	9);

INSERT INTO rentavailablefrom VALUES (
	(to_date('2012/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	(to_date('2013/04/01 08:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	99.0,
	NULL,
	110,
	'default term',
	1005,
	10);

/*
 * rated
 */
INSERT INTO rated VALUES (
        6.0,
        'Just Okay',
        (to_date('2011/11/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        2,
        'zw2219@columbia.edu');

INSERT INTO rated VALUES (
        7.0,
        'Very good',
        (to_date('2000/05/04 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        3,
        'hc2361@columbia.edu');

INSERT INTO rated VALUES (
        7.0,
        'Worth watching',
        (to_date('2007/12/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        4,
        'eac2192@columbia.edu');

INSERT INTO rated VALUES (
        8.0,
        'Impressive Movie',
        (to_date('2012/02/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        5,
        'eac2192@columbia.edu');

INSERT INTO rated VALUES (
        9.0,
        'Epic!',
        (to_date('2008/11/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        6,
        'hc2361@columbia.edu');

INSERT INTO rated VALUES (
        10.0,
        'Best movie ever!',
        (to_date('2011/01/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        7,
        'nx2120@columbia.edu');

INSERT INTO rated VALUES (
        5.0,
        'Not so bad',
        (to_date('2012/04/17 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        8,
        'duxin29@gmail.com');

INSERT INTO rated VALUES(
        3.0,
        'Couldn’t help sleeping',
        (to_date('2002/05/06 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        9,
        'zw2219@columbia.edu');

INSERT INTO rated VALUES(
        1.0,
        'Could not be worse',
        (to_date('1995/03/14 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        10,
        'chris.dangelo@gmail.com');

INSERT INTO rated VALUES(
        10.0,
        'My favorite movie.',
        (to_date('1999/07/16 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        1,
        'chris.dangelo@gmail.com');

INSERT INTO rated VALUES(
        9.5,
        'Second favorite movie.',
        (to_date('1999/07/17 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        2,
        'chris.dangelo@gmail.com');

INSERT INTO rated VALUES(
        2.0,
        'So boring',
        (to_date('2012/04/06 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        1,
        'duxin29@gmail.com');

/*
 * watched 
 */

INSERT INTO watched VALUES (
        (to_date('2004/05/17 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        2,
        'zw2219@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2011/03/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        3,
        'hc2361@columbia.edu')


INSERT INTO watched VALUES(
        (to_date('2012/02/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        4,
        'eac2192@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2006/12/07 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        5,
        'eac2192@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2012/09/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        6,
        'hc2361@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2012/11/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        7,
        'nx2120@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2012/08/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        8,
        'zw2219@columbia.edu');


INSERT INTO watched VALUES (
        (to_date('2011/07/09 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        9,
        'duxin29@gmail.com');

INSERT INTO watched VALUES (
        (to_date('2010/06/22 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        7,
        'chris.dangelo@gmail.com');

INSERT INTO watched VALUES (
        (to_date('2009/06/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        10,
        'chris.dangelo@gmail.com');


INSERT INTO watched VALUES (
        (to_date('2012/04/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
        1,
        'duxin29@gmail.com');

/* * * * * * * * * * * * * * * * *
 *
 * workedin
 * 
 * * * * * * * * * * * * * * * * */

/*
 * Harrison Ford
 */

INSERT INTO workedin VALUES (
	'Hans Solo',
	'Cast',
	3,
	NULL,
	3,
	200);

INSERT INTO workedin VALUES (
	'Hans Solo',
	'Cast',
	3,
	NULL,
	4,
	200);

INSERT INTO workedin VALUES (
	'Indiana Jones',
	'Cast',
	1,
	NULL,
	8,
	200);

INSERT INTO workedin VALUES (
	'Indiana Jones',
	'Cast',
	1,
	NULL,
	9,
	200);

/*
 * Humphrey Bogart
 */

INSERT INTO workedin VALUES (
	'Rick',
	'Cast',
	1,
	NULL,
	10,
	204);


/*
 * Diane Keaton
 */

INSERT INTO workedin VALUES (
	'Annie Hall',
	'Cast',
	2,
	NULL,
	1,
	203);

/*
 * Woody Allen
 */

INSERT INTO workedin VALUES (
	'Alvy Singer',
	'Cast',
	1,
	NULL,
	1,
	202);

/*
 * Carrie Fisher
 */

INSERT INTO workedin VALUES (
	'Princess Leia',
	'Cast',
	3,
	NULL,
	3,
	201);

INSERT INTO workedin VALUES (
	'Princess Leia',
	'Cast',
	3,
	NULL,
	4,
	201);

/*
 * Jeff Goldblum
 */

INSERT INTO workedin VALUES (
	'Dr. Ian Malcom',
	'Cast',
	4,
	NULL,
	2,
	205);

/*
 * Laura Dern
 */

INSERT INTO workedin VALUES (
	'Dr. Ellie Sattler',
	'Cast',
	3,
	NULL,
	2,
	206);

/*
 * Steven Speilberg
 */

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	2,
	207);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	8,
	207);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	9,
	207);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Producer',
	6,
	207);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Producer',
	7,
	207);


INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Producer',
	5,
	207);

/*
 * Michael J. Fox
 */

INSERT INTO workedin VALUES (
	'Marty McFly',
	'Cast',
	1,
	NULL,
	6,
	208);

INSERT INTO workedin VALUES (
	'Marty McFly',
	'Cast',
	1,
	NULL,
	7,
	208);

/*
 * Christopher Lloyd
 */

INSERT INTO workedin VALUES (
	'Dr. Emmet Brown',
	'Cast',
	2,
	NULL,
	6,
	209);

INSERT INTO workedin VALUES (
	'Dr. Emmet Brown',
	'Cast',
	2,
	NULL,
	7,
	209);

INSERT INTO workedin VALUES (
	'Judge Doom',
	'Cast',
	2,
	NULL,
	5,
	209);

/*
 * Robert Zemeckis
 */

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	6,
	210);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	7,
	210);

INSERT INTO workedin VALUES (
	NULL,
	'Crew',
	1,
	'Director',
	5,
	210);


/* * * * * * * * * * * * * * * * 
 *
 *  Type of
 *
 * * * * * * * * * * * * * * * */

/* Annie Hall */

INSERT INTO typeof VALUES (
	1,
	'Comedy');

INSERT INTO typeof VALUES (
	1,
	'Drama');

INSERT INTO typeof VALUES (
	1,
	'Romance');

/* Jurassic Park */

INSERT INTO typeof VALUES (
	2,
	'Adventure');

INSERT INTO typeof VALUES (
	2,
	'Family');

INSERT INTO typeof VALUES (
	2,
	'Sci-Fi');

/* Star Wars */

INSERT INTO typeof VALUES (
	3,
	'Action');

INSERT INTO typeof VALUES (
	3,
	'Adventure');

INSERT INTO typeof VALUES (
	3,
	'Fantasy');

/* Star Wars Empire Strikes Back */

INSERT INTO typeof VALUES (
	4,
	'Action');

INSERT INTO typeof VALUES (
	4,
	'Adventure');

INSERT INTO typeof VALUES (
	4,
	'Fantasy');

/* Roger Rabbit */

INSERT INTO typeof VALUES (
	5,
	'Animation');

INSERT INTO typeof VALUES (
	5,
	'Comedy');

INSERT INTO typeof VALUES (
	5,
	'Crime');

/* Back to the Future */

INSERT INTO typeof VALUES (
	6,
	'Adventure');

INSERT INTO typeof VALUES (
	6,
	'Comedy')

INSERT INTO typeof VALUES (
	6,
	'Sci-Fi');

/* Back to the Future II */

INSERT INTO typeof VALUES (
	7,
	'Adventure');

INSERT INTO typeof VALUES (
	7,
	'Comedy');

INSERT INTO typeof VALUES (
	7,
	'Sci-Fi');


/* Indiana Jones */

INSERT INTO typeof VALUES (
	8,
	'Action');

INSERT INTO typeof VALUES (
	8,
	'Adventure');

/* Indiana Jones Last Crusade */

INSERT INTO typeof VALUES (
	9,
	'Action');

INSERT INTO typeof VALUES (
	9,
	'Adventure');

/* Casbalanca */

INSERT INTO typeof VALUES (
	10,
	'Drama');

INSERT INTO typeof VALUES (
	10,
	'Romance');

INSERT INTO typeof VALUES (
	10,
	'War');

/*
 * CASTCREWRATED
 */

INSERT INTO castcrewrated VALUES (
	8.0,
	(to_date('2012/07/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	200,
	'hmg2138@columbia.edu');

INSERT INTO castcrewrated VALUES (
	9.0,
	(to_date('2003/05/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	201,
	'nx2120@columbia.edu');

INSERT INTO castcrewrated VALUES (
	8.0,
	(to_date('2012/08/16 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	202,
	'nx2120@columbia.edu');

INSERT INTO castcrewrated VALUES (
	9.0,
	(to_date('2013/08/12 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	203,
	'duxin29@gmail.com');

INSERT INTO castcrewrated VALUES (
	5.0,
	(to_date('2004/08/04 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	204,
	'duxin29@gmail.com');

INSERT INTO castcrewrated VALUES (
	8.0,
	(to_date('2005/10/10 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	205,
	'eac2192@columbia.edu');

INSERT INTO castcrewrated VALUES (
	1.0,
	(to_date('2004/11/11 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	206,
	'hmg2138@columbia.edu');

INSERT INTO castcrewrated VALUES (
	9.0,
	(to_date('2011/07/16 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	206,
	'zw2219@columbia.edu');

INSERT INTO castcrewrated VALUES (
	9.0,
	(to_date('2013/01/04 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	203,
	'chris.dangelo@gmail.com');

INSERT INTO castcrewrated VALUES (
	7.0,
	(to_date('2010/07/04 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	204,
	'chris.dangelo@gmail.com');

INSERT INTO castcrewrated VALUES (
	4.0,
	(to_date('2009/06/04 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	208,
	'chris.dangelo@gmail.com');

INSERT INTO castcrewrated VALUES (
	10.0,
	(to_date('2010/08/05 00:00:00', 'yyyy/mm/dd hh24:mi:ss')),
	209,
	'chris.dangelo@gmail.com');
	
/*
 * friendwith
 */

INSERT INTO friendswith VALUES (
	'eac2192@columbia.edu',
	'duxin29@gmail.com');

INSERT INTO friendswith VALUES (
	'zw2219@columbia.edu',
	'duxin29@gmail.com');

INSERT INTO friendswith VALUES (
	'hc2361@columbia.edu',
	'chris.dangelo@gmail.com');

INSERT INTO friendswith VALUES (
	'chris.dangelo@gmail.com',
	'duxin29@gmail.com');

INSERT INTO friendswith VALUES (
	'eac2192@columbia.edu',
	'hc2361@columbia.edu');

INSERT INTO friendswith VALUES (
	'eac2192@columbia.edu',
	'nx2120@columbia.edu');

INSERT INTO friendswith VALUES (
	'nx2120@columbia.edu',
	'chris.dangelo@gmail.com');

INSERT INTO friendswith VALUES (
	'eac2192@columbia.edu',
	'zw2219@columbia.edu');

INSERT INTO friendswith VALUES (
	'nx2120@columbia.edu',
	'duxin29@gmail.com');

INSERT INTO friendswith VALUES (
	'eac2192@columbia.edu',
	'hmg2138@columbia.edu');

INSERT INTO friendswith VALUES (
	'nx2120@columbia.edu',
	'hmg2138@columbia.edu');

