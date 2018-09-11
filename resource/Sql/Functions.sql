-- concat
--  将多个字符串拼接成一个字符串。
--  @usage: select concat(str1, str2, ...) as str from dual;
--  @param: str字符串，如果有任何一个str为null，则返回null。
select concat('Hello', 'World') from dual;


-- group_concat
--  group by(如果存在) 中的字符串拼接。
--  @usage: select group_concat(separator, str1, str2,...) from table group by condition;
--  @param: separator分隔符。
--  @param: str字符串。
select group_concat(' ', 'Hello', 'World') from dual;


-- concat_ws
--  分隔符拼接。(concat with separator)是concat的特殊形式。
--  @usage: select concat_ws(separator, str1, str2,...) from dual;
--  @param: separator分隔符，如果separator为null，则返回null。
--  @param: str字符串，会忽略为null的str，不会忽略为''的str。
select concat_ws(' ', 'Hello', 'World') from dual;


-- find_in_set
--  在逗号分隔的字符串列表(strList)中查询指定字符串(str)的位置。
--  @usage: find_in_set(str, strList);
--  @param: str要查询的字符串；不能包含逗号分隔符。
--  @param: strList逗号分隔的字符串列表。
--  @return: the position of str in strList.
select find_in_set('b', 'a,b,c,d') from dual;


-- locate
--  返回子串在父串中出现的第一个位置。
--  @usage: locate(substr, str);
--  @param: substr子串。
--  @param: str父串。
--  @return: start with 1, the position of the substr occur in sub. if not exit, return 0.
select locate('bar', 'foobarbar') from dual;


-- instr
--  返回子串在父串中出现的第一个位置。
--  @usage: locate(str, substr);
--  @param: str父串。
--  @param: substr子串。
--  @return: start with 1, the position of the substr occur in sub. if not exit, return 0.
select instr('foobarbar', 'bar') from dual; 


-- left
--  返回字符串str的最左边len个字符。
--  @usage: left(str, len)。
select left('foobarbar', 5) from dual;


-- right
--  返回字符串str的最右边len个字符。
--  @usage: right(str, len)。
select right('foobarbar', 5) from dual;


-- substring
--  返回字符串的子串，从1开始。
--  @usage: substring(str, position);
--  @param: str字符串
--  @param: position子串起始位置
select substring('Quadratically',5) from dual;


-- repeat
--  返回重复count此str的字符串
--  @usage: repeat(str, count);
--  @param: str源字符串
--  @param: count次数
select repeat('MySQL', 3) from dual;


-- reverse
--  字符串反转
--  @usage: reverse(str);
select reverse('Hellow world') from dual;


-- replace
--  字符串替换，将str中的from_str替换为to_str。
--  @usage: replace(str, from_str, to_str);
--  @param: str待替换字符串
--  @param: from_str源字符串
--  @param: to_str目标字符串
select replace('www.mysql.com', 'w', 'W') from dual;


-- insert
--  字符串替换，从posi开始长度为len的字符串由to_str代替。
--  @usage: insert(str, posi, len, to_str);
--  @param: str源字符串。
--  @param: posi开始位置。
--  @param: len长度。
--  @param: to_str目标字符串。
select insert('www.mysql.com', 5, 5, 'MySQL') from dual;

