## mysql参数优化

### 线程优化

允许同时有32个线程去innodb引擎取数据，要和cpu核数匹配；
innodb_thread_concurrency=32

innodb_file_io_threads=4

### 内存优化

禁用查询cache
query_cache_type=0
query_cache_size=0

innodb_buffer_pool_size=50G
sort_buffer_size 
join_buffer_size  
read_buffer_size 
read_rnd_buffer_size 
net_buffer

### io优化

每秒后台进程处理IO数据的上限，一般为IO QPS总能力的75%
innodb_io_capacity=20000

几个innodb redo log日志组
innodb_log_files_in_group=4
innodb_log_file_size=1000M

SSD直接写硬盘，不写硬盘cache，也就是绕过fsync()刷硬盘
innodb_flush_method=O_DIRECT

当脏块达到innodb_buffer_pool_size的50%时，触发检查点，写磁盘
innodb_max_dirty_pages_pct=50

一表一文件，可以避免共享表空间的IO竞争
innodb_file_per_table=on

默认是16K，这里是SSD
innodb_page_size=4k

SSD设置为0，SAS打开刷新相邻块，随机访问转换为顺序访问
innodb_flush_neighbors=0


### 连接的优化

max_connections=3000
max_user_connections=2980

table_open_cache=1024

thread_cache_size=512


### 数据一致性的优化

innodb_flush_log_at_trx_commit=1

sync_binlog=1