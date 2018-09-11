-- 时间偏移
--  interval: year, month, day, hour, minute, second;
select date_add(now(), interval 1 day) from dual;


-- 日期格式转化
select date_format(now(), '%Y-%m-%d %H-%i-%s') from dual;


--  当前时间
select sysdate() from dual;
select now() from dual;
select current_date from dual;
select current_time from dual;


-- 当前时间所处的星期天数((1=星期天，2=星期一, …7=星期六))
select dayofweek(now()) from dual;


-- 当前时间在一年中的天数
select dayofyear(now()) from dual;


-- 获取日期的年/月/日
select year('2018-09-10 12:00:00') from dual;
select month('2018-09-10 12:00:00') from dual;
select dayofmonth('2018-09-10 12:00:00') from dual;
select date('2018-09-10 12:00:00') from dual;


-- 字符串转化为日期
select str_to_date('2016-12-15 16:48:40', '%Y-%m-%d %H:%i:%S') from dual;

