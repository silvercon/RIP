REDIS_HOME = '/usr/local/redis'

--Tree $REDIS_HOME
|____redis.conf
|____src
| |____redis-cli

--查看redis密码
cat redis.conf | grep pass

--进入控制台
--  进入#REDIS_HOME#/src
./redis-cli

--使用管理员权限
auto $PASSWORD

--查看所有的keys
keys * 