SELECT 
    ITEM_ID,ITEM_NAME,RARITY
FROM ITEM_TREE
JOIN ITEM_INFO USING(ITEM_ID)
WHERE 
    PARENT_ITEM_ID IN(
        SELECT ITEM_ID
        FROM ITEM_INFO
        WHERE RARITY = 'RARE'
    )
ORDER BY ITEM_ID DESC