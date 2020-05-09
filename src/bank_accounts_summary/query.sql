      SELECT
             CONCAT(uf.first_name, ' ',  uf.last_name) 'name',
             tl.vpa,
             tl.balance current_balance,
             CASE
                WHEN tl.balance + uf.credit_limit >= 0 THEN 'NO'
                ELSE 'YES'
             END credit_limit_breached
        FROM user_financial_detail uf
  INNER JOIN (
            SELECT vpa, sum(total_amount) balance
              FROM (
                    SELECT paid_by vpa,
                           sum(-amount) total_amount
                      FROM transaction_log
                  GROUP BY paid_by
                    UNION ALL
                    SELECT paid_to vpa,
                           sum(amount) total_amount
                      FROM transaction_log
                  GROUP BY paid_to
                ) balance
        GROUP BY vpa
        ) tl on tl.vpa = uf.vpa;
