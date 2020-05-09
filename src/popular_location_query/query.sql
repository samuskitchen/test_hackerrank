     SELECT
            p.NAME,
            c.NAME
       FROM LOCATIONS AS l
       JOIN COMPANIES AS c ON c.LOCATION_ID = l.ID
       JOIN PEOPLE AS p ON p.COMPANY_ID = c.ID
      WHERE L.ID = (
                      SELECT l.ID
                        FROM LOCATIONS AS l
                        JOIN COMPANIES AS c ON c.LOCATION_ID = l.ID
                    GROUP BY l.ID
                    ORDER BY COUNT(c.ID) DESC
                       LIMIT 1
                    );
