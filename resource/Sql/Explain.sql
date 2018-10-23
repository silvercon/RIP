-- MySQL执行计划
--  explain select * from table_name [join] [where];

--  @return columns: select_type | table | type | possible_keys | key | key_len | ref | rows | Extra

--  @column1: select_type
--  @column2: table- 查询的表
--  @column3: type- 重要的字段，表示使用的是何种连接，效率由高到低的类型包括[const | eq_reg | ref | range | index | ALL]
--    @join type1: const- 表中有一条数据配置查询条件，常见于code条件查询
--    @join type2: eq_reg- 
--    @join type3: ref
--    @join type4: range
--    @join type5: index- 索引扫描，常见于查询索引字段
--    @join type6: ALL- 全表扫描，常见于不使用where
--  @column4: possible_keys- 查询中可能使用到的索引
--  @column5: key- 实际用到的索引
--  @column6: key_len- 索引长度，在不影响精度的情况下越短越好
--  @column7: ref- 显示索引的那一列被使用了
--  @column8: rows- 返回值的行数
--  @column9: Extra

