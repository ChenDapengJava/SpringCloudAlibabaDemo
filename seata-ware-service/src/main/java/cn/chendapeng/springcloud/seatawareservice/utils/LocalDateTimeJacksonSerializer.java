package cn.chendapeng.springcloud.seatawareservice.utils;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.seata.rm.datasource.undo.parser.spi.JacksonSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * seata LocalDateTime 序列化扩展点
 *
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-09-02 21:17
 */
public class LocalDateTimeJacksonSerializer implements JacksonSerializer<LocalDateTime> {

    public static final String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    @Override
    public Class<LocalDateTime> type() {
        return LocalDateTime.class;
    }

    @Override
    public JsonSerializer<LocalDateTime> ser() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(NORM_DATETIME_MS_PATTERN));
    }

    @Override
    public JsonDeserializer<? extends LocalDateTime> deser() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(NORM_DATETIME_MS_PATTERN));
    }
}
