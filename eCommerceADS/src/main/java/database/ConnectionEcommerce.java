package database;

import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.CachedResultSetMetaData;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Extension;
import com.mysql.jdbc.Field;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.MysqlIO;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.ServerPreparedStatement;
import com.mysql.jdbc.SingleByteCharsetConverter;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.StatementInterceptorV2;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.ShardingKey;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.Executor;
import javax.faces.context.FacesContext;

/**
 *
 * @author Victor
 */
public class ConnectionEcommerce implements MySQLConnection{

    private MySQLConnection con;

    public ConnectionEcommerce(Connection con) {
        this.con = (MySQLConnection) con;
    }

    private String getSessionID() {
        String idSession = null;
        try {
            idSession = FacesContext.getCurrentInstance().getExternalContext().getSessionId(false);
        } catch (Exception e) {
        }
        return idSession;
    }

    @Override
    public <T> T unwrap(Class<T> type) throws SQLException {
        return con.unwrap(type);
    }

    @Override
    public boolean isWrapperFor(Class<?> type) throws SQLException {
        return con.isWrapperFor(type);
    }

    @Override
    public int hashCode() {
        return con.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return con.equals(obj);
    }

    @Override
    public String toString() {
        return con.toString();
    }

    @Override
    public String exposeAsXml() throws SQLException {
        return con.exposeAsXml();
    }

    @Override
    public boolean getAllowLoadLocalInfile() {
        return con.getAllowLoadLocalInfile();
    }

    @Override
    public boolean getAllowMultiQueries() {
        return con.getAllowMultiQueries();
    }

    @Override
    public boolean getAllowNanAndInf() {
        return con.getAllowNanAndInf();
    }

    @Override
    public boolean getAllowUrlInLocalInfile() {
        return con.getAllowUrlInLocalInfile();
    }

    @Override
    public boolean getAlwaysSendSetIsolation() {
        return con.getAlwaysSendSetIsolation();
    }

    @Override
    public boolean getAutoDeserialize() {
        return con.getAutoDeserialize();
    }

    @Override
    public boolean getAutoGenerateTestcaseScript() {
        return con.getAutoGenerateTestcaseScript();
    }

    @Override
    public boolean getAutoReconnectForPools() {
        return con.getAutoReconnectForPools();
    }

    @Override
    public int getBlobSendChunkSize() {
        return con.getBlobSendChunkSize();
    }

    @Override
    public boolean getCacheCallableStatements() {
        return con.getCacheCallableStatements();
    }

    @Override
    public boolean getCachePreparedStatements() {
        return con.getCachePreparedStatements();
    }

    @Override
    public boolean getCacheResultSetMetadata() {
        return con.getCacheResultSetMetadata();
    }

    @Override
    public boolean getCacheServerConfiguration() {
        return con.getCacheServerConfiguration();
    }

    @Override
    public int getCallableStatementCacheSize() {
        return con.getCallableStatementCacheSize();
    }

    @Override
    public boolean getCapitalizeTypeNames() {
        return con.getCapitalizeTypeNames();
    }

    @Override
    public String getCharacterSetResults() {
        return con.getCharacterSetResults();
    }

    @Override
    public boolean getClobberStreamingResults() {
        return con.getClobberStreamingResults();
    }

    @Override
    public String getClobCharacterEncoding() {
        return con.getClobCharacterEncoding();
    }

    @Override
    public String getConnectionCollation() {
        return con.getConnectionCollation();
    }

    @Override
    public int getConnectTimeout() {
        return con.getConnectTimeout();
    }

    @Override
    public boolean getContinueBatchOnError() {
        return con.getContinueBatchOnError();
    }

    @Override
    public boolean getCreateDatabaseIfNotExist() {
        return con.getCreateDatabaseIfNotExist();
    }

    @Override
    public int getDefaultFetchSize() {
        return con.getDefaultFetchSize();
    }

    @Override
    public boolean getDontTrackOpenResources() {
        return con.getDontTrackOpenResources();
    }

    @Override
    public boolean getDumpQueriesOnException() {
        return con.getDumpQueriesOnException();
    }

    @Override
    public boolean getDynamicCalendars() {
        return con.getDynamicCalendars();
    }

    @Override
    public boolean getElideSetAutoCommits() {
        return con.getElideSetAutoCommits();
    }

    @Override
    public boolean getEmptyStringsConvertToZero() {
        return con.getEmptyStringsConvertToZero();
    }

    @Override
    public boolean getEmulateLocators() {
        return con.getEmulateLocators();
    }

    @Override
    public boolean getEmulateUnsupportedPstmts() {
        return con.getEmulateUnsupportedPstmts();
    }

    @Override
    public boolean getEnablePacketDebug() {
        return con.getEnablePacketDebug();
    }

    @Override
    public String getEncoding() {
        return con.getEncoding();
    }

    @Override
    public boolean getExplainSlowQueries() {
        return con.getExplainSlowQueries();
    }

    @Override
    public boolean getFailOverReadOnly() {
        return con.getFailOverReadOnly();
    }

    @Override
    public boolean getGatherPerformanceMetrics() {
        return con.getGatherPerformanceMetrics();
    }

    @Override
    public boolean getHoldResultsOpenOverStatementClose() {
        return con.getHoldResultsOpenOverStatementClose();
    }

    @Override
    public boolean getIgnoreNonTxTables() {
        return con.getIgnoreNonTxTables();
    }

    @Override
    public int getInitialTimeout() {
        return con.getInitialTimeout();
    }

    @Override
    public boolean getInteractiveClient() {
        return con.getInteractiveClient();
    }

    @Override
    public boolean getIsInteractiveClient() {
        return con.getIsInteractiveClient();
    }

    @Override
    public boolean getJdbcCompliantTruncation() {
        return con.getJdbcCompliantTruncation();
    }

    @Override
    public int getLocatorFetchBufferSize() {
        return con.getLocatorFetchBufferSize();
    }

    @Override
    public String getLogger() {
        return con.getLogger();
    }

    @Override
    public String getLoggerClassName() {
        return con.getLoggerClassName();
    }

    @Override
    public boolean getLogSlowQueries() {
        return con.getLogSlowQueries();
    }

    @Override
    public boolean getMaintainTimeStats() {
        return con.getMaintainTimeStats();
    }

    @Override
    public int getMaxQuerySizeToLog() {
        return con.getMaxQuerySizeToLog();
    }

    @Override
    public int getMaxReconnects() {
        return con.getMaxReconnects();
    }

    @Override
    public int getMaxRows() {
        return con.getMaxRows();
    }

    @Override
    public int getMetadataCacheSize() {
        return con.getMetadataCacheSize();
    }

    @Override
    public boolean getNoDatetimeStringSync() {
        return con.getNoDatetimeStringSync();
    }

    @Override
    public boolean getNullCatalogMeansCurrent() {
        return con.getNullCatalogMeansCurrent();
    }

    @Override
    public boolean getNullNamePatternMatchesAll() {
        return con.getNullNamePatternMatchesAll();
    }

    @Override
    public int getPacketDebugBufferSize() {
        return con.getPacketDebugBufferSize();
    }

    @Override
    public boolean getParanoid() {
        return con.getParanoid();
    }

    @Override
    public boolean getPedantic() {
        return con.getPedantic();
    }

    @Override
    public int getPreparedStatementCacheSize() {
        return con.getPreparedStatementCacheSize();
    }

    @Override
    public int getPreparedStatementCacheSqlLimit() {
        return con.getPreparedStatementCacheSqlLimit();
    }

    @Override
    public boolean getProfileSql() {
        return con.getProfileSql();
    }

    @Override
    public boolean getProfileSQL() {
        return con.getProfileSQL();
    }

    @Override
    public String getPropertiesTransform() {
        return con.getPropertiesTransform();
    }

    @Override
    public int getQueriesBeforeRetryMaster() {
        return con.getQueriesBeforeRetryMaster();
    }

    @Override
    public boolean getReconnectAtTxEnd() {
        return con.getReconnectAtTxEnd();
    }

    @Override
    public boolean getRelaxAutoCommit() {
        return con.getRelaxAutoCommit();
    }

    @Override
    public int getReportMetricsIntervalMillis() {
        return con.getReportMetricsIntervalMillis();
    }

    @Override
    public boolean getRequireSSL() {
        return con.getRequireSSL();
    }

    @Override
    public boolean getRollbackOnPooledClose() {
        return con.getRollbackOnPooledClose();
    }

    @Override
    public boolean getRoundRobinLoadBalance() {
        return con.getRoundRobinLoadBalance();
    }

    @Override
    public boolean getRunningCTS13() {
        return con.getRunningCTS13();
    }

    @Override
    public int getSecondsBeforeRetryMaster() {
        return con.getSecondsBeforeRetryMaster();
    }

    @Override
    public String getServerTimezone() {
        return con.getServerTimezone();
    }

    @Override
    public String getSessionVariables() {
        return con.getSessionVariables();
    }

    @Override
    public int getSlowQueryThresholdMillis() {
        return con.getSlowQueryThresholdMillis();
    }

    @Override
    public String getSocketFactoryClassName() {
        return con.getSocketFactoryClassName();
    }

    @Override
    public int getSocketTimeout() {
        return con.getSocketTimeout();
    }

    @Override
    public boolean getStrictFloatingPoint() {
        return con.getStrictFloatingPoint();
    }

    @Override
    public boolean getStrictUpdates() {
        return con.getStrictUpdates();
    }

    @Override
    public boolean getTinyInt1isBit() {
        return con.getTinyInt1isBit();
    }

    @Override
    public boolean getTraceProtocol() {
        return con.getTraceProtocol();
    }

    @Override
    public boolean getTransformedBitIsBoolean() {
        return con.getTransformedBitIsBoolean();
    }

    @Override
    public boolean getUseCompression() {
        return con.getUseCompression();
    }

    @Override
    public boolean getUseFastIntParsing() {
        return con.getUseFastIntParsing();
    }

    @Override
    public boolean getUseHostsInPrivileges() {
        return con.getUseHostsInPrivileges();
    }

    @Override
    public boolean getUseInformationSchema() {
        return con.getUseInformationSchema();
    }

    @Override
    public boolean getUseLocalSessionState() {
        return con.getUseLocalSessionState();
    }

    @Override
    public boolean getUseOldUTF8Behavior() {
        return con.getUseOldUTF8Behavior();
    }

    @Override
    public boolean getUseOnlyServerErrorMessages() {
        return con.getUseOnlyServerErrorMessages();
    }

    @Override
    public boolean getUseReadAheadInput() {
        return con.getUseReadAheadInput();
    }

    @Override
    public boolean getUseServerPreparedStmts() {
        return con.getUseServerPreparedStmts();
    }

    @Override
    public boolean getUseSqlStateCodes() {
        return con.getUseSqlStateCodes();
    }

    @Override
    public boolean getUseSSL() {
        return con.getUseSSL();
    }

    @Override
    public boolean isUseSSLExplicit() {
        return con.isUseSSLExplicit();
    }

    @Override
    public boolean getUseStreamLengthsInPrepStmts() {
        return con.getUseStreamLengthsInPrepStmts();
    }

    @Override
    public boolean getUseTimezone() {
        return con.getUseTimezone();
    }

    @Override
    public boolean getUseUltraDevWorkAround() {
        return con.getUseUltraDevWorkAround();
    }

    @Override
    public boolean getUseUnbufferedInput() {
        return con.getUseUnbufferedInput();
    }

    @Override
    public boolean getUseUnicode() {
        return con.getUseUnicode();
    }

    @Override
    public boolean getUseUsageAdvisor() {
        return con.getUseUsageAdvisor();
    }

    @Override
    public boolean getYearIsDateType() {
        return con.getYearIsDateType();
    }

    @Override
    public String getZeroDateTimeBehavior() {
        return con.getZeroDateTimeBehavior();
    }

    @Override
    public void setAllowLoadLocalInfile(boolean bln) {
        con.setAllowLoadLocalInfile(bln);
    }

    @Override
    public void setAllowMultiQueries(boolean bln) {
        con.setAllowMultiQueries(bln);
    }

    @Override
    public void setAllowNanAndInf(boolean bln) {
        con.setAllowNanAndInf(bln);
    }

    @Override
    public void setAllowUrlInLocalInfile(boolean bln) {
        con.setAllowUrlInLocalInfile(bln);
    }

    @Override
    public void setAlwaysSendSetIsolation(boolean bln) {
        con.setAlwaysSendSetIsolation(bln);
    }

    @Override
    public void setAutoDeserialize(boolean bln) {
        con.setAutoDeserialize(bln);
    }

    @Override
    public void setAutoGenerateTestcaseScript(boolean bln) {
        con.setAutoGenerateTestcaseScript(bln);
    }

    @Override
    public void setAutoReconnect(boolean bln) {
        con.setAutoReconnect(bln);
    }

    @Override
    public void setAutoReconnectForConnectionPools(boolean bln) {
        con.setAutoReconnectForConnectionPools(bln);
    }

    @Override
    public void setAutoReconnectForPools(boolean bln) {
        con.setAutoReconnectForPools(bln);
    }

    @Override
    public void setBlobSendChunkSize(String string) throws SQLException {
        con.setBlobSendChunkSize(string);
    }

    @Override
    public void setCacheCallableStatements(boolean bln) {
        con.setCacheCallableStatements(bln);
    }

    @Override
    public void setCachePreparedStatements(boolean bln) {
        con.setCachePreparedStatements(bln);
    }

    @Override
    public void setCacheResultSetMetadata(boolean bln) {
        con.setCacheResultSetMetadata(bln);
    }

    @Override
    public void setCacheServerConfiguration(boolean bln) {
        con.setCacheServerConfiguration(bln);
    }

    @Override
    public void setCallableStatementCacheSize(int i) throws SQLException {
        con.setCallableStatementCacheSize(i);
    }

    @Override
    public void setCapitalizeDBMDTypes(boolean bln) {
        con.setCapitalizeDBMDTypes(bln);
    }

    @Override
    public void setCapitalizeTypeNames(boolean bln) {
        con.setCapitalizeTypeNames(bln);
    }

    @Override
    public void setCharacterEncoding(String string) {
        con.setCharacterEncoding(string);
    }

    @Override
    public void setCharacterSetResults(String string) {
        con.setCharacterSetResults(string);
    }

    @Override
    public void setClobberStreamingResults(boolean bln) {
        con.setClobberStreamingResults(bln);
    }

    @Override
    public void setClobCharacterEncoding(String string) {
        con.setClobCharacterEncoding(string);
    }

    @Override
    public void setConnectionCollation(String string) {
        con.setConnectionCollation(string);
    }

    @Override
    public void setConnectTimeout(int i) throws SQLException {
        con.setConnectTimeout(i);
    }

    @Override
    public void setContinueBatchOnError(boolean bln) {
        con.setContinueBatchOnError(bln);
    }

    @Override
    public void setCreateDatabaseIfNotExist(boolean bln) {
        con.setCreateDatabaseIfNotExist(bln);
    }

    @Override
    public void setDefaultFetchSize(int i) throws SQLException {
        con.setDefaultFetchSize(i);
    }

    @Override
    public void setDetectServerPreparedStmts(boolean bln) {
        con.setDetectServerPreparedStmts(bln);
    }

    @Override
    public void setDontTrackOpenResources(boolean bln) {
        con.setDontTrackOpenResources(bln);
    }

    @Override
    public void setDumpQueriesOnException(boolean bln) {
        con.setDumpQueriesOnException(bln);
    }

    @Override
    public void setDynamicCalendars(boolean bln) {
        con.setDynamicCalendars(bln);
    }

    @Override
    public void setElideSetAutoCommits(boolean bln) {
        con.setElideSetAutoCommits(bln);
    }

    @Override
    public void setEmptyStringsConvertToZero(boolean bln) {
        con.setEmptyStringsConvertToZero(bln);
    }

    @Override
    public void setEmulateLocators(boolean bln) {
        con.setEmulateLocators(bln);
    }

    @Override
    public void setEmulateUnsupportedPstmts(boolean bln) {
        con.setEmulateUnsupportedPstmts(bln);
    }

    @Override
    public void setEnablePacketDebug(boolean bln) {
        con.setEnablePacketDebug(bln);
    }

    @Override
    public void setEncoding(String string) {
        con.setEncoding(string);
    }

    @Override
    public void setExplainSlowQueries(boolean bln) {
        con.setExplainSlowQueries(bln);
    }

    @Override
    public void setFailOverReadOnly(boolean bln) {
        con.setFailOverReadOnly(bln);
    }

    @Override
    public void setGatherPerformanceMetrics(boolean bln) {
        con.setGatherPerformanceMetrics(bln);
    }

    @Override
    public void setHoldResultsOpenOverStatementClose(boolean bln) {
        con.setHoldResultsOpenOverStatementClose(bln);
    }

    @Override
    public void setIgnoreNonTxTables(boolean bln) {
        con.setIgnoreNonTxTables(bln);
    }

    @Override
    public void setInitialTimeout(int i) throws SQLException {
        con.setInitialTimeout(i);
    }

    @Override
    public void setIsInteractiveClient(boolean bln) {
        con.setIsInteractiveClient(bln);
    }

    @Override
    public void setJdbcCompliantTruncation(boolean bln) {
        con.setJdbcCompliantTruncation(bln);
    }

    @Override
    public void setLocatorFetchBufferSize(String string) throws SQLException {
        con.setLocatorFetchBufferSize(string);
    }

    @Override
    public void setLogger(String string) {
        con.setLogger(string);
    }

    @Override
    public void setLoggerClassName(String string) {
        con.setLoggerClassName(string);
    }

    @Override
    public void setLogSlowQueries(boolean bln) {
        con.setLogSlowQueries(bln);
    }

    @Override
    public void setMaintainTimeStats(boolean bln) {
        con.setMaintainTimeStats(bln);
    }

    @Override
    public void setMaxQuerySizeToLog(int i) throws SQLException {
        con.setMaxQuerySizeToLog(i);
    }

    @Override
    public void setMaxReconnects(int i) throws SQLException {
        con.setMaxReconnects(i);
    }

    @Override
    public void setMaxRows(int i) throws SQLException {
        con.setMaxRows(i);
    }

    @Override
    public void setMetadataCacheSize(int i) throws SQLException {
        con.setMetadataCacheSize(i);
    }

    @Override
    public void setNoDatetimeStringSync(boolean bln) {
        con.setNoDatetimeStringSync(bln);
    }

    @Override
    public void setNullCatalogMeansCurrent(boolean bln) {
        con.setNullCatalogMeansCurrent(bln);
    }

    @Override
    public void setNullNamePatternMatchesAll(boolean bln) {
        con.setNullNamePatternMatchesAll(bln);
    }

    @Override
    public void setPacketDebugBufferSize(int i) throws SQLException {
        con.setPacketDebugBufferSize(i);
    }

    @Override
    public void setParanoid(boolean bln) {
        con.setParanoid(bln);
    }

    @Override
    public void setPedantic(boolean bln) {
        con.setPedantic(bln);
    }

    @Override
    public void setPreparedStatementCacheSize(int i) throws SQLException {
        con.setPreparedStatementCacheSize(i);
    }

    @Override
    public void setPreparedStatementCacheSqlLimit(int i) throws SQLException {
        con.setPreparedStatementCacheSqlLimit(i);
    }

    @Override
    public void setProfileSql(boolean bln) {
        con.setProfileSql(bln);
    }

    @Override
    public void setProfileSQL(boolean bln) {
        con.setProfileSQL(bln);
    }

    @Override
    public void setPropertiesTransform(String string) {
        con.setPropertiesTransform(string);
    }

    @Override
    public void setQueriesBeforeRetryMaster(int i) throws SQLException {
        con.setQueriesBeforeRetryMaster(i);
    }

    @Override
    public void setReconnectAtTxEnd(boolean bln) {
        con.setReconnectAtTxEnd(bln);
    }

    @Override
    public void setRelaxAutoCommit(boolean bln) {
        con.setRelaxAutoCommit(bln);
    }

    @Override
    public void setReportMetricsIntervalMillis(int i) throws SQLException {
        con.setReportMetricsIntervalMillis(i);
    }

    @Override
    public void setRequireSSL(boolean bln) {
        con.setRequireSSL(bln);
    }

    @Override
    public void setRetainStatementAfterResultSetClose(boolean bln) {
        con.setRetainStatementAfterResultSetClose(bln);
    }

    @Override
    public void setRollbackOnPooledClose(boolean bln) {
        con.setRollbackOnPooledClose(bln);
    }

    @Override
    public void setRoundRobinLoadBalance(boolean bln) {
        con.setRoundRobinLoadBalance(bln);
    }

    @Override
    public void setRunningCTS13(boolean bln) {
        con.setRunningCTS13(bln);
    }

    @Override
    public void setSecondsBeforeRetryMaster(int i) throws SQLException {
        con.setSecondsBeforeRetryMaster(i);
    }

    @Override
    public void setServerTimezone(String string) {
        con.setServerTimezone(string);
    }

    @Override
    public void setSessionVariables(String string) {
        con.setSessionVariables(string);
    }

    @Override
    public void setSlowQueryThresholdMillis(int i) throws SQLException {
        con.setSlowQueryThresholdMillis(i);
    }

    @Override
    public void setSocketFactoryClassName(String string) {
        con.setSocketFactoryClassName(string);
    }

    @Override
    public void setSocketTimeout(int i) throws SQLException {
        con.setSocketTimeout(i);
    }

    @Override
    public void setStrictFloatingPoint(boolean bln) {
        con.setStrictFloatingPoint(bln);
    }

    @Override
    public void setStrictUpdates(boolean bln) {
        con.setStrictUpdates(bln);
    }

    @Override
    public void setTinyInt1isBit(boolean bln) {
        con.setTinyInt1isBit(bln);
    }

    @Override
    public void setTraceProtocol(boolean bln) {
        con.setTraceProtocol(bln);
    }

    @Override
    public void setTransformedBitIsBoolean(boolean bln) {
        con.setTransformedBitIsBoolean(bln);
    }

    @Override
    public void setUseCompression(boolean bln) {
        con.setUseCompression(bln);
    }

    @Override
    public void setUseFastIntParsing(boolean bln) {
        con.setUseFastIntParsing(bln);
    }

    @Override
    public void setUseHostsInPrivileges(boolean bln) {
        con.setUseHostsInPrivileges(bln);
    }

    @Override
    public void setUseInformationSchema(boolean bln) {
        con.setUseInformationSchema(bln);
    }

    @Override
    public void setUseLocalSessionState(boolean bln) {
        con.setUseLocalSessionState(bln);
    }

    @Override
    public void setUseOldUTF8Behavior(boolean bln) {
        con.setUseOldUTF8Behavior(bln);
    }

    @Override
    public void setUseOnlyServerErrorMessages(boolean bln) {
        con.setUseOnlyServerErrorMessages(bln);
    }

    @Override
    public void setUseReadAheadInput(boolean bln) {
        con.setUseReadAheadInput(bln);
    }

    @Override
    public void setUseServerPreparedStmts(boolean bln) {
        con.setUseServerPreparedStmts(bln);
    }

    @Override
    public void setUseSqlStateCodes(boolean bln) {
        con.setUseSqlStateCodes(bln);
    }

    @Override
    public void setUseSSL(boolean bln) {
        con.setUseSSL(bln);
    }

    @Override
    public void setUseStreamLengthsInPrepStmts(boolean bln) {
        con.setUseStreamLengthsInPrepStmts(bln);
    }

    @Override
    public void setUseTimezone(boolean bln) {
        con.setUseTimezone(bln);
    }

    @Override
    public void setUseUltraDevWorkAround(boolean bln) {
        con.setUseUltraDevWorkAround(bln);
    }

    @Override
    public void setUseUnbufferedInput(boolean bln) {
        con.setUseUnbufferedInput(bln);
    }

    @Override
    public void setUseUnicode(boolean bln) {
        con.setUseUnicode(bln);
    }

    @Override
    public void setUseUsageAdvisor(boolean bln) {
        con.setUseUsageAdvisor(bln);
    }

    @Override
    public void setYearIsDateType(boolean bln) {
        con.setYearIsDateType(bln);
    }

    @Override
    public void setZeroDateTimeBehavior(String string) {
        con.setZeroDateTimeBehavior(string);
    }

    @Override
    public boolean useUnbufferedInput() {
        return con.useUnbufferedInput();
    }

    @Override
    public boolean getUseCursorFetch() {
        return con.getUseCursorFetch();
    }

    @Override
    public void setUseCursorFetch(boolean bln) {
        con.setUseCursorFetch(bln);
    }

    @Override
    public boolean getOverrideSupportsIntegrityEnhancementFacility() {
        return con.getOverrideSupportsIntegrityEnhancementFacility();
    }

    @Override
    public void setOverrideSupportsIntegrityEnhancementFacility(boolean bln) {
        con.setOverrideSupportsIntegrityEnhancementFacility(bln);
    }

    @Override
    public boolean getNoTimezoneConversionForTimeType() {
        return con.getNoTimezoneConversionForTimeType();
    }

    @Override
    public void setNoTimezoneConversionForTimeType(boolean bln) {
        con.setNoTimezoneConversionForTimeType(bln);
    }

    @Override
    public boolean getNoTimezoneConversionForDateType() {
        return con.getNoTimezoneConversionForDateType();
    }

    @Override
    public void setNoTimezoneConversionForDateType(boolean bln) {
        con.setNoTimezoneConversionForDateType(bln);
    }

    @Override
    public boolean getCacheDefaultTimezone() {
        return con.getCacheDefaultTimezone();
    }

    @Override
    public void setCacheDefaultTimezone(boolean bln) {
        con.setCacheDefaultTimezone(bln);
    }

    @Override
    public boolean getUseJDBCCompliantTimezoneShift() {
        return con.getUseJDBCCompliantTimezoneShift();
    }

    @Override
    public void setUseJDBCCompliantTimezoneShift(boolean bln) {
        con.setUseJDBCCompliantTimezoneShift(bln);
    }

    @Override
    public boolean getAutoClosePStmtStreams() {
        return con.getAutoClosePStmtStreams();
    }

    @Override
    public void setAutoClosePStmtStreams(boolean bln) {
        con.setAutoClosePStmtStreams(bln);
    }

    @Override
    public boolean getProcessEscapeCodesForPrepStmts() {
        return con.getProcessEscapeCodesForPrepStmts();
    }

    @Override
    public void setProcessEscapeCodesForPrepStmts(boolean bln) {
        con.setProcessEscapeCodesForPrepStmts(bln);
    }

    @Override
    public boolean getUseGmtMillisForDatetimes() {
        return con.getUseGmtMillisForDatetimes();
    }

    @Override
    public void setUseGmtMillisForDatetimes(boolean bln) {
        con.setUseGmtMillisForDatetimes(bln);
    }

    @Override
    public boolean getDumpMetadataOnColumnNotFound() {
        return con.getDumpMetadataOnColumnNotFound();
    }

    @Override
    public void setDumpMetadataOnColumnNotFound(boolean bln) {
        con.setDumpMetadataOnColumnNotFound(bln);
    }

    @Override
    public String getResourceId() {
        return con.getResourceId();
    }

    @Override
    public void setResourceId(String string) {
        con.setResourceId(string);
    }

    @Override
    public boolean getRewriteBatchedStatements() {
        return con.getRewriteBatchedStatements();
    }

    @Override
    public void setRewriteBatchedStatements(boolean bln) {
        con.setRewriteBatchedStatements(bln);
    }

    @Override
    public boolean getJdbcCompliantTruncationForReads() {
        return con.getJdbcCompliantTruncationForReads();
    }

    @Override
    public void setJdbcCompliantTruncationForReads(boolean bln) {
        con.setJdbcCompliantTruncationForReads(bln);
    }

    @Override
    public boolean getUseJvmCharsetConverters() {
        return con.getUseJvmCharsetConverters();
    }

    @Override
    public void setUseJvmCharsetConverters(boolean bln) {
        con.setUseJvmCharsetConverters(bln);
    }

    @Override
    public boolean getPinGlobalTxToPhysicalConnection() {
        return con.getPinGlobalTxToPhysicalConnection();
    }

    @Override
    public void setPinGlobalTxToPhysicalConnection(boolean bln) {
        con.setPinGlobalTxToPhysicalConnection(bln);
    }

    @Override
    public void setGatherPerfMetrics(boolean bln) {
        con.setGatherPerfMetrics(bln);
    }

    @Override
    public boolean getGatherPerfMetrics() {
        return con.getGatherPerfMetrics();
    }

    @Override
    public void setUltraDevHack(boolean bln) {
        con.setUltraDevHack(bln);
    }

    @Override
    public boolean getUltraDevHack() {
        return con.getUltraDevHack();
    }

    @Override
    public void setInteractiveClient(boolean bln) {
        con.setInteractiveClient(bln);
    }

    @Override
    public void setSocketFactory(String string) {
        con.setSocketFactory(string);
    }

    @Override
    public String getSocketFactory() {
        return con.getSocketFactory();
    }

    @Override
    public void setUseServerPrepStmts(boolean bln) {
        con.setUseServerPrepStmts(bln);
    }

    @Override
    public boolean getUseServerPrepStmts() {
        return con.getUseServerPrepStmts();
    }

    @Override
    public void setCacheCallableStmts(boolean bln) {
        con.setCacheCallableStmts(bln);
    }

    @Override
    public boolean getCacheCallableStmts() {
        return con.getCacheCallableStmts();
    }

    @Override
    public void setCachePrepStmts(boolean bln) {
        con.setCachePrepStmts(bln);
    }

    @Override
    public boolean getCachePrepStmts() {
        return con.getCachePrepStmts();
    }

    @Override
    public void setCallableStmtCacheSize(int i) throws SQLException {
        con.setCallableStmtCacheSize(i);
    }

    @Override
    public int getCallableStmtCacheSize() {
        return con.getCallableStmtCacheSize();
    }

    @Override
    public void setPrepStmtCacheSize(int i) throws SQLException {
        con.setPrepStmtCacheSize(i);
    }

    @Override
    public int getPrepStmtCacheSize() {
        return con.getPrepStmtCacheSize();
    }

    @Override
    public void setPrepStmtCacheSqlLimit(int i) throws SQLException {
        con.setPrepStmtCacheSqlLimit(i);
    }

    @Override
    public int getPrepStmtCacheSqlLimit() {
        return con.getPrepStmtCacheSqlLimit();
    }

    @Override
    public boolean getNoAccessToProcedureBodies() {
        return con.getNoAccessToProcedureBodies();
    }

    @Override
    public void setNoAccessToProcedureBodies(boolean bln) {
        con.setNoAccessToProcedureBodies(bln);
    }

    @Override
    public boolean getUseOldAliasMetadataBehavior() {
        return con.getUseOldAliasMetadataBehavior();
    }

    @Override
    public void setUseOldAliasMetadataBehavior(boolean bln) {
        con.setUseOldAliasMetadataBehavior(bln);
    }

    @Override
    public String getClientCertificateKeyStorePassword() {
        return con.getClientCertificateKeyStorePassword();
    }

    @Override
    public void setClientCertificateKeyStorePassword(String string) {
        con.setClientCertificateKeyStorePassword(string);
    }

    @Override
    public String getClientCertificateKeyStoreType() {
        return con.getClientCertificateKeyStoreType();
    }

    @Override
    public void setClientCertificateKeyStoreType(String string) {
        con.setClientCertificateKeyStoreType(string);
    }

    @Override
    public String getClientCertificateKeyStoreUrl() {
        return con.getClientCertificateKeyStoreUrl();
    }

    @Override
    public void setClientCertificateKeyStoreUrl(String string) {
        con.setClientCertificateKeyStoreUrl(string);
    }

    @Override
    public String getTrustCertificateKeyStorePassword() {
        return con.getTrustCertificateKeyStorePassword();
    }

    @Override
    public void setTrustCertificateKeyStorePassword(String string) {
        con.setTrustCertificateKeyStorePassword(string);
    }

    @Override
    public String getTrustCertificateKeyStoreType() {
        return con.getTrustCertificateKeyStoreType();
    }

    @Override
    public void setTrustCertificateKeyStoreType(String string) {
        con.setTrustCertificateKeyStoreType(string);
    }

    @Override
    public String getTrustCertificateKeyStoreUrl() {
        return con.getTrustCertificateKeyStoreUrl();
    }

    @Override
    public void setTrustCertificateKeyStoreUrl(String string) {
        con.setTrustCertificateKeyStoreUrl(string);
    }

    @Override
    public boolean getUseSSPSCompatibleTimezoneShift() {
        return con.getUseSSPSCompatibleTimezoneShift();
    }

    @Override
    public void setUseSSPSCompatibleTimezoneShift(boolean bln) {
        con.setUseSSPSCompatibleTimezoneShift(bln);
    }

    @Override
    public boolean getTreatUtilDateAsTimestamp() {
        return con.getTreatUtilDateAsTimestamp();
    }

    @Override
    public void setTreatUtilDateAsTimestamp(boolean bln) {
        con.setTreatUtilDateAsTimestamp(bln);
    }

    @Override
    public boolean getUseFastDateParsing() {
        return con.getUseFastDateParsing();
    }

    @Override
    public void setUseFastDateParsing(boolean bln) {
        con.setUseFastDateParsing(bln);
    }

    @Override
    public String getLocalSocketAddress() {
        return con.getLocalSocketAddress();
    }

    @Override
    public void setLocalSocketAddress(String string) {
        con.setLocalSocketAddress(string);
    }

    @Override
    public void setUseConfigs(String string) {
        con.setUseConfigs(string);
    }

    @Override
    public String getUseConfigs() {
        return con.getUseConfigs();
    }

    @Override
    public boolean getGenerateSimpleParameterMetadata() {
        return con.getGenerateSimpleParameterMetadata();
    }

    @Override
    public void setGenerateSimpleParameterMetadata(boolean bln) {
        con.setGenerateSimpleParameterMetadata(bln);
    }

    @Override
    public boolean getLogXaCommands() {
        return con.getLogXaCommands();
    }

    @Override
    public void setLogXaCommands(boolean bln) {
        con.setLogXaCommands(bln);
    }

    @Override
    public int getResultSetSizeThreshold() {
        return con.getResultSetSizeThreshold();
    }

    @Override
    public void setResultSetSizeThreshold(int i) throws SQLException {
        con.setResultSetSizeThreshold(i);
    }

    @Override
    public int getNetTimeoutForStreamingResults() {
        return con.getNetTimeoutForStreamingResults();
    }

    @Override
    public void setNetTimeoutForStreamingResults(int i) throws SQLException {
        con.setNetTimeoutForStreamingResults(i);
    }

    @Override
    public boolean getEnableQueryTimeouts() {
        return con.getEnableQueryTimeouts();
    }

    @Override
    public void setEnableQueryTimeouts(boolean bln) {
        con.setEnableQueryTimeouts(bln);
    }

    @Override
    public boolean getPadCharsWithSpace() {
        return con.getPadCharsWithSpace();
    }

    @Override
    public void setPadCharsWithSpace(boolean bln) {
        con.setPadCharsWithSpace(bln);
    }

    @Override
    public boolean getUseDynamicCharsetInfo() {
        return con.getUseDynamicCharsetInfo();
    }

    @Override
    public void setUseDynamicCharsetInfo(boolean bln) {
        con.setUseDynamicCharsetInfo(bln);
    }

    @Override
    public String getClientInfoProvider() {
        return con.getClientInfoProvider();
    }

    @Override
    public void setClientInfoProvider(String string) {
        con.setClientInfoProvider(string);
    }

    @Override
    public boolean getPopulateInsertRowWithDefaultValues() {
        return con.getPopulateInsertRowWithDefaultValues();
    }

    @Override
    public void setPopulateInsertRowWithDefaultValues(boolean bln) {
        con.setPopulateInsertRowWithDefaultValues(bln);
    }

    @Override
    public String getLoadBalanceStrategy() {
        return con.getLoadBalanceStrategy();
    }

    @Override
    public void setLoadBalanceStrategy(String string) {
        con.setLoadBalanceStrategy(string);
    }

    @Override
    public String getServerAffinityOrder() {
        return con.getServerAffinityOrder();
    }

    @Override
    public void setServerAffinityOrder(String string) {
        con.setServerAffinityOrder(string);
    }

    @Override
    public boolean getTcpNoDelay() {
        return con.getTcpNoDelay();
    }

    @Override
    public void setTcpNoDelay(boolean bln) {
        con.setTcpNoDelay(bln);
    }

    @Override
    public boolean getTcpKeepAlive() {
        return con.getTcpKeepAlive();
    }

    @Override
    public void setTcpKeepAlive(boolean bln) {
        con.setTcpKeepAlive(bln);
    }

    @Override
    public int getTcpRcvBuf() {
        return con.getTcpRcvBuf();
    }

    @Override
    public void setTcpRcvBuf(int i) throws SQLException {
        con.setTcpRcvBuf(i);
    }

    @Override
    public int getTcpSndBuf() {
        return con.getTcpSndBuf();
    }

    @Override
    public void setTcpSndBuf(int i) throws SQLException {
        con.setTcpSndBuf(i);
    }

    @Override
    public int getTcpTrafficClass() {
        return con.getTcpTrafficClass();
    }

    @Override
    public void setTcpTrafficClass(int i) throws SQLException {
        con.setTcpTrafficClass(i);
    }

    @Override
    public boolean getUseNanosForElapsedTime() {
        return con.getUseNanosForElapsedTime();
    }

    @Override
    public void setUseNanosForElapsedTime(boolean bln) {
        con.setUseNanosForElapsedTime(bln);
    }

    @Override
    public long getSlowQueryThresholdNanos() {
        return con.getSlowQueryThresholdNanos();
    }

    @Override
    public void setSlowQueryThresholdNanos(long l) throws SQLException {
        con.setSlowQueryThresholdNanos(l);
    }

    @Override
    public String getStatementInterceptors() {
        return con.getStatementInterceptors();
    }

    @Override
    public void setStatementInterceptors(String string) {
        con.setStatementInterceptors(string);
    }

    @Override
    public boolean getUseDirectRowUnpack() {
        return con.getUseDirectRowUnpack();
    }

    @Override
    public void setUseDirectRowUnpack(boolean bln) {
        con.setUseDirectRowUnpack(bln);
    }

    @Override
    public String getLargeRowSizeThreshold() {
        return con.getLargeRowSizeThreshold();
    }

    @Override
    public void setLargeRowSizeThreshold(String string) throws SQLException {
        con.setLargeRowSizeThreshold(string);
    }

    @Override
    public boolean getUseBlobToStoreUTF8OutsideBMP() {
        return con.getUseBlobToStoreUTF8OutsideBMP();
    }

    @Override
    public void setUseBlobToStoreUTF8OutsideBMP(boolean bln) {
        con.setUseBlobToStoreUTF8OutsideBMP(bln);
    }

    @Override
    public String getUtf8OutsideBmpExcludedColumnNamePattern() {
        return con.getUtf8OutsideBmpExcludedColumnNamePattern();
    }

    @Override
    public void setUtf8OutsideBmpExcludedColumnNamePattern(String string) {
        con.setUtf8OutsideBmpExcludedColumnNamePattern(string);
    }

    @Override
    public String getUtf8OutsideBmpIncludedColumnNamePattern() {
        return con.getUtf8OutsideBmpIncludedColumnNamePattern();
    }

    @Override
    public void setUtf8OutsideBmpIncludedColumnNamePattern(String string) {
        con.setUtf8OutsideBmpIncludedColumnNamePattern(string);
    }

    @Override
    public boolean getIncludeInnodbStatusInDeadlockExceptions() {
        return con.getIncludeInnodbStatusInDeadlockExceptions();
    }

    @Override
    public void setIncludeInnodbStatusInDeadlockExceptions(boolean bln) {
        con.setIncludeInnodbStatusInDeadlockExceptions(bln);
    }

    @Override
    public boolean getIncludeThreadDumpInDeadlockExceptions() {
        return con.getIncludeThreadDumpInDeadlockExceptions();
    }

    @Override
    public void setIncludeThreadDumpInDeadlockExceptions(boolean bln) {
        con.setIncludeThreadDumpInDeadlockExceptions(bln);
    }

    @Override
    public boolean getIncludeThreadNamesAsStatementComment() {
        return con.getIncludeThreadNamesAsStatementComment();
    }

    @Override
    public void setIncludeThreadNamesAsStatementComment(boolean bln) {
        con.setIncludeThreadNamesAsStatementComment(bln);
    }

    @Override
    public boolean getBlobsAreStrings() {
        return con.getBlobsAreStrings();
    }

    @Override
    public void setBlobsAreStrings(boolean bln) {
        con.setBlobsAreStrings(bln);
    }

    @Override
    public boolean getFunctionsNeverReturnBlobs() {
        return con.getFunctionsNeverReturnBlobs();
    }

    @Override
    public void setFunctionsNeverReturnBlobs(boolean bln) {
        con.setFunctionsNeverReturnBlobs(bln);
    }

    @Override
    public boolean getAutoSlowLog() {
        return con.getAutoSlowLog();
    }

    @Override
    public void setAutoSlowLog(boolean bln) {
        con.setAutoSlowLog(bln);
    }

    @Override
    public String getConnectionLifecycleInterceptors() {
        return con.getConnectionLifecycleInterceptors();
    }

    @Override
    public void setConnectionLifecycleInterceptors(String string) {
        con.setConnectionLifecycleInterceptors(string);
    }

    @Override
    public String getProfilerEventHandler() {
        return con.getProfilerEventHandler();
    }

    @Override
    public void setProfilerEventHandler(String string) {
        con.setProfilerEventHandler(string);
    }

    @Override
    public boolean getVerifyServerCertificate() {
        return con.getVerifyServerCertificate();
    }

    @Override
    public void setVerifyServerCertificate(boolean bln) {
        con.setVerifyServerCertificate(bln);
    }

    @Override
    public boolean getUseLegacyDatetimeCode() {
        return con.getUseLegacyDatetimeCode();
    }

    @Override
    public void setUseLegacyDatetimeCode(boolean bln) {
        con.setUseLegacyDatetimeCode(bln);
    }

    @Override
    public boolean getSendFractionalSeconds() {
        return con.getSendFractionalSeconds();
    }

    @Override
    public void setSendFractionalSeconds(boolean bln) {
        con.setSendFractionalSeconds(bln);
    }

    @Override
    public int getSelfDestructOnPingSecondsLifetime() {
        return con.getSelfDestructOnPingSecondsLifetime();
    }

    @Override
    public void setSelfDestructOnPingSecondsLifetime(int i) throws SQLException {
        con.setSelfDestructOnPingSecondsLifetime(i);
    }

    @Override
    public int getSelfDestructOnPingMaxOperations() {
        return con.getSelfDestructOnPingMaxOperations();
    }

    @Override
    public void setSelfDestructOnPingMaxOperations(int i) throws SQLException {
        con.setSelfDestructOnPingMaxOperations(i);
    }

    @Override
    public boolean getUseColumnNamesInFindColumn() {
        return con.getUseColumnNamesInFindColumn();
    }

    @Override
    public void setUseColumnNamesInFindColumn(boolean bln) {
        con.setUseColumnNamesInFindColumn(bln);
    }

    @Override
    public boolean getUseLocalTransactionState() {
        return con.getUseLocalTransactionState();
    }

    @Override
    public void setUseLocalTransactionState(boolean bln) {
        con.setUseLocalTransactionState(bln);
    }

    @Override
    public boolean getCompensateOnDuplicateKeyUpdateCounts() {
        return con.getCompensateOnDuplicateKeyUpdateCounts();
    }

    @Override
    public void setCompensateOnDuplicateKeyUpdateCounts(boolean bln) {
        con.setCompensateOnDuplicateKeyUpdateCounts(bln);
    }

    @Override
    public void setUseAffectedRows(boolean bln) {
        con.setUseAffectedRows(bln);
    }

    @Override
    public boolean getUseAffectedRows() {
        return con.getUseAffectedRows();
    }

    @Override
    public void setPasswordCharacterEncoding(String string) {
        con.setPasswordCharacterEncoding(string);
    }

    @Override
    public String getPasswordCharacterEncoding() {
        return con.getPasswordCharacterEncoding();
    }

    @Override
    public int getLoadBalanceBlacklistTimeout() {
        return con.getLoadBalanceBlacklistTimeout();
    }

    @Override
    public void setLoadBalanceBlacklistTimeout(int i) throws SQLException {
        con.setLoadBalanceBlacklistTimeout(i);
    }

    @Override
    public void setRetriesAllDown(int i) throws SQLException {
        con.setRetriesAllDown(i);
    }

    @Override
    public int getRetriesAllDown() {
        return con.getRetriesAllDown();
    }

    @Override
    public void setExceptionInterceptors(String string) {
        con.setExceptionInterceptors(string);
    }

    @Override
    public String getExceptionInterceptors() {
        return con.getExceptionInterceptors();
    }

    @Override
    public boolean getQueryTimeoutKillsConnection() {
        return con.getQueryTimeoutKillsConnection();
    }

    @Override
    public void setQueryTimeoutKillsConnection(boolean bln) {
        con.setQueryTimeoutKillsConnection(bln);
    }

    @Override
    public int getMaxAllowedPacket() {
        return con.getMaxAllowedPacket();
    }

    @Override
    public boolean getRetainStatementAfterResultSetClose() {
        return con.getRetainStatementAfterResultSetClose();
    }

    @Override
    public int getLoadBalancePingTimeout() {
        return con.getLoadBalancePingTimeout();
    }

    @Override
    public void setLoadBalancePingTimeout(int i) throws SQLException {
        con.setLoadBalancePingTimeout(i);
    }

    @Override
    public boolean getLoadBalanceValidateConnectionOnSwapServer() {
        return con.getLoadBalanceValidateConnectionOnSwapServer();
    }

    @Override
    public void setLoadBalanceValidateConnectionOnSwapServer(boolean bln) {
        con.setLoadBalanceValidateConnectionOnSwapServer(bln);
    }

    @Override
    public String getLoadBalanceConnectionGroup() {
        return con.getLoadBalanceConnectionGroup();
    }

    @Override
    public void setLoadBalanceConnectionGroup(String string) {
        con.setLoadBalanceConnectionGroup(string);
    }

    @Override
    public String getLoadBalanceExceptionChecker() {
        return con.getLoadBalanceExceptionChecker();
    }

    @Override
    public void setLoadBalanceExceptionChecker(String string) {
        con.setLoadBalanceExceptionChecker(string);
    }

    @Override
    public String getLoadBalanceSQLStateFailover() {
        return con.getLoadBalanceSQLStateFailover();
    }

    @Override
    public void setLoadBalanceSQLStateFailover(String string) {
        con.setLoadBalanceSQLStateFailover(string);
    }

    @Override
    public String getLoadBalanceSQLExceptionSubclassFailover() {
        return con.getLoadBalanceSQLExceptionSubclassFailover();
    }

    @Override
    public void setLoadBalanceSQLExceptionSubclassFailover(String string) {
        con.setLoadBalanceSQLExceptionSubclassFailover(string);
    }

    @Override
    public boolean getLoadBalanceEnableJMX() {
        return con.getLoadBalanceEnableJMX();
    }

    @Override
    public void setLoadBalanceEnableJMX(boolean bln) {
        con.setLoadBalanceEnableJMX(bln);
    }

    @Override
    public void setLoadBalanceHostRemovalGracePeriod(int i) throws SQLException {
        con.setLoadBalanceHostRemovalGracePeriod(i);
    }

    @Override
    public int getLoadBalanceHostRemovalGracePeriod() {
        return con.getLoadBalanceHostRemovalGracePeriod();
    }

    @Override
    public void setLoadBalanceAutoCommitStatementThreshold(int i) throws SQLException {
        con.setLoadBalanceAutoCommitStatementThreshold(i);
    }

    @Override
    public int getLoadBalanceAutoCommitStatementThreshold() {
        return con.getLoadBalanceAutoCommitStatementThreshold();
    }

    @Override
    public void setLoadBalanceAutoCommitStatementRegex(String string) {
        con.setLoadBalanceAutoCommitStatementRegex(string);
    }

    @Override
    public String getLoadBalanceAutoCommitStatementRegex() {
        return con.getLoadBalanceAutoCommitStatementRegex();
    }

    @Override
    public void setAuthenticationPlugins(String string) {
        con.setAuthenticationPlugins(string);
    }

    @Override
    public String getAuthenticationPlugins() {
        return con.getAuthenticationPlugins();
    }

    @Override
    public void setDisabledAuthenticationPlugins(String string) {
        con.setDisabledAuthenticationPlugins(string);
    }

    @Override
    public String getDisabledAuthenticationPlugins() {
        return con.getDisabledAuthenticationPlugins();
    }

    @Override
    public void setDefaultAuthenticationPlugin(String string) {
        con.setDefaultAuthenticationPlugin(string);
    }

    @Override
    public String getDefaultAuthenticationPlugin() {
        return con.getDefaultAuthenticationPlugin();
    }

    @Override
    public void setParseInfoCacheFactory(String string) {
        con.setParseInfoCacheFactory(string);
    }

    @Override
    public String getParseInfoCacheFactory() {
        return con.getParseInfoCacheFactory();
    }

    @Override
    public void setServerConfigCacheFactory(String string) {
        con.setServerConfigCacheFactory(string);
    }

    @Override
    public String getServerConfigCacheFactory() {
        return con.getServerConfigCacheFactory();
    }

    @Override
    public void setDisconnectOnExpiredPasswords(boolean bln) {
        con.setDisconnectOnExpiredPasswords(bln);
    }

    @Override
    public boolean getDisconnectOnExpiredPasswords() {
        return con.getDisconnectOnExpiredPasswords();
    }

    @Override
    public boolean getAllowMasterDownConnections() {
        return con.getAllowMasterDownConnections();
    }

    @Override
    public void setAllowMasterDownConnections(boolean bln) {
        con.setAllowMasterDownConnections(bln);
    }

    @Override
    public boolean getAllowSlaveDownConnections() {
        return con.getAllowSlaveDownConnections();
    }

    @Override
    public void setAllowSlaveDownConnections(boolean bln) {
        con.setAllowSlaveDownConnections(bln);
    }

    @Override
    public boolean getReadFromMasterWhenNoSlaves() {
        return con.getReadFromMasterWhenNoSlaves();
    }

    @Override
    public void setReadFromMasterWhenNoSlaves(boolean bln) {
        con.setReadFromMasterWhenNoSlaves(bln);
    }

    @Override
    public boolean getReplicationEnableJMX() {
        return con.getReplicationEnableJMX();
    }

    @Override
    public void setReplicationEnableJMX(boolean bln) {
        con.setReplicationEnableJMX(bln);
    }

    @Override
    public void setGetProceduresReturnsFunctions(boolean bln) {
        con.setGetProceduresReturnsFunctions(bln);
    }

    @Override
    public boolean getGetProceduresReturnsFunctions() {
        return con.getGetProceduresReturnsFunctions();
    }

    @Override
    public void setDetectCustomCollations(boolean bln) {
        con.setDetectCustomCollations(bln);
    }

    @Override
    public boolean getDetectCustomCollations() {
        return con.getDetectCustomCollations();
    }

    @Override
    public String getServerRSAPublicKeyFile() {
        return con.getServerRSAPublicKeyFile();
    }

    @Override
    public void setServerRSAPublicKeyFile(String string) throws SQLException {
        con.setServerRSAPublicKeyFile(string);
    }

    @Override
    public boolean getAllowPublicKeyRetrieval() {
        return con.getAllowPublicKeyRetrieval();
    }

    @Override
    public void setAllowPublicKeyRetrieval(boolean bln) throws SQLException {
        con.setAllowPublicKeyRetrieval(bln);
    }

    @Override
    public void setDontCheckOnDuplicateKeyUpdateInSQL(boolean bln) {
        con.setDontCheckOnDuplicateKeyUpdateInSQL(bln);
    }

    @Override
    public boolean getDontCheckOnDuplicateKeyUpdateInSQL() {
        return con.getDontCheckOnDuplicateKeyUpdateInSQL();
    }

    @Override
    public void setSocksProxyHost(String string) {
        con.setSocksProxyHost(string);
    }

    @Override
    public String getSocksProxyHost() {
        return con.getSocksProxyHost();
    }

    @Override
    public void setSocksProxyPort(int i) throws SQLException {
        con.setSocksProxyPort(i);
    }

    @Override
    public int getSocksProxyPort() {
        return con.getSocksProxyPort();
    }

    @Override
    public boolean getReadOnlyPropagatesToServer() {
        return con.getReadOnlyPropagatesToServer();
    }

    @Override
    public void setReadOnlyPropagatesToServer(boolean bln) {
        con.setReadOnlyPropagatesToServer(bln);
    }

    @Override
    public String getEnabledSSLCipherSuites() {
        return con.getEnabledSSLCipherSuites();
    }

    @Override
    public void setEnabledSSLCipherSuites(String string) {
        con.setEnabledSSLCipherSuites(string);
    }

    @Override
    public String getEnabledTLSProtocols() {
        return con.getEnabledTLSProtocols();
    }

    @Override
    public void setEnabledTLSProtocols(String string) {
        con.setEnabledTLSProtocols(string);
    }

    @Override
    public boolean getEnableEscapeProcessing() {
        return con.getEnableEscapeProcessing();
    }

    @Override
    public void setEnableEscapeProcessing(boolean bln) {
        con.setEnableEscapeProcessing(bln);
    }

    @Override
    public Statement createStatement() throws SQLException {
        return con.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String string) throws SQLException {
//        System.out.println("[id:" + con.getId() + "] [Session id:" + getSessionID() + "]" + string);
        return con.prepareStatement(string);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return con.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return con.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        con.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return con.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        con.commit();
    }

    @Override
    public void rollback() throws SQLException {
        con.rollback();
    }

    @Override
    public void close() throws SQLException {
//        System.out.println("[Fechou a conexão id:" + con.getId() + "] [host:" + con.getHost() + "] [Session id:" + getSessionID() + "]");
        con.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return con.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return con.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        con.setReadOnly(readOnly);
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        con.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return con.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        con.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return con.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return con.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        con.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return con.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
//        System.out.println("id:" + con.getId() + "-" + sql);
        return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return con.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return con.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        con.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        con.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return con.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return con.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return con.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        con.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        con.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return con.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return con.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return con.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return con.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return con.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return con.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return con.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return con.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        con.setClientInfo(name, value);
    }

    @Override
    public void setClientInfo(Properties prprts) throws SQLClientInfoException {
        con.setClientInfo(prprts);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return con.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return con.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return con.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return con.createStruct(typeName, attributes);
    }

    @Override
    public void beginRequest() throws SQLException {
        con.beginRequest();
    }

    @Override
    public void endRequest() throws SQLException {
        con.endRequest();
    }

    @Override
    public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey, int timeout) throws SQLException {
        return con.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
    }

    @Override
    public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
        return con.setShardingKeyIfValid(shardingKey, timeout);
    }

    @Override
    public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey) throws SQLException {
        con.setShardingKey(shardingKey, superShardingKey);
    }

    @Override
    public void setShardingKey(ShardingKey shardingKey) throws SQLException {
        con.setShardingKey(shardingKey);
    }

    @Override
    public void changeUser(String string, String string1) throws SQLException {
        con.changeUser(string, string1);
    }

    @Override
    public void clearHasTriedMaster() {
        con.clearHasTriedMaster();
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string) throws SQLException {
        return con.clientPrepareStatement(string);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string, int i) throws SQLException {
        return con.clientPrepareStatement(string, i);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string, int i, int i1) throws SQLException {
        return con.clientPrepareStatement(string, i, i1);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string, int[] ints) throws SQLException {
        return con.clientPrepareStatement(string, ints);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string, int i, int i1, int i2) throws SQLException {
        return con.clientPrepareStatement(string, i, i1, i2);
    }

    @Override
    public PreparedStatement clientPrepareStatement(String string, String[] strings) throws SQLException {
        return con.clientPrepareStatement(string, strings);
    }

    @Override
    public String getServerCharacterEncoding() {
        return con.getServerCharacterEncoding();
    }

    @Override
    public boolean hasTriedMaster() {
        return con.hasTriedMaster();
    }

    @Override
    public boolean isInGlobalTx() {
        return con.isInGlobalTx();
    }

    @Override
    public void setInGlobalTx(boolean bln) {
        con.setInGlobalTx(bln);
    }

    @Override
    public boolean isMasterConnection() {
        return con.isMasterConnection();
    }

    @Override
    public boolean isNoBackslashEscapesSet() {
        return con.isNoBackslashEscapesSet();
    }

    @Override
    public boolean isSameResource(com.mysql.jdbc.Connection cnctn) {
        return con.isSameResource(cnctn);
    }

    @Override
    public boolean parserKnowsUnicode() {
        return con.parserKnowsUnicode();
    }

    @Override
    public void ping() throws SQLException {
        con.ping();
    }

    @Override
    public void resetServerState() throws SQLException {
        con.resetServerState();
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string) throws SQLException {
        return con.serverPrepareStatement(string);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string, int i) throws SQLException {
        return con.serverPrepareStatement(string, i);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string, int i, int i1) throws SQLException {
        return con.serverPrepareStatement(string, i, i1);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string, int i, int i1, int i2) throws SQLException {
        return con.serverPrepareStatement(string, i, i1, i2);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string, int[] ints) throws SQLException {
        return con.serverPrepareStatement(string, ints);
    }

    @Override
    public PreparedStatement serverPrepareStatement(String string, String[] strings) throws SQLException {
        return con.serverPrepareStatement(string, strings);
    }

    @Override
    public void setFailedOver(boolean bln) {
        con.setFailedOver(bln);
    }

    @Override
    public void setPreferSlaveDuringFailover(boolean bln) {
        con.setPreferSlaveDuringFailover(bln);
    }

    @Override
    public void setStatementComment(String string) {
        con.setStatementComment(string);
    }

    @Override
    public boolean supportsIsolationLevel() {
        return con.supportsIsolationLevel();
    }

    @Override
    public boolean supportsQuotedIdentifiers() {
        return con.supportsQuotedIdentifiers();
    }

    @Override
    public boolean supportsTransactions() {
        return con.supportsTransactions();
    }

    @Override
    public boolean versionMeetsMinimum(int i, int i1, int i2) throws SQLException {
        return con.versionMeetsMinimum(i, i1, i2);
    }

    @Override
    public void reportQueryTime(long l) {
        con.reportQueryTime(l);
    }

    @Override
    public void initializeExtension(Extension extnsn) throws SQLException {
        con.initializeExtension(extnsn);
    }

    @Override
    public boolean hasSameProperties(com.mysql.jdbc.Connection cnctn) {
        return con.hasSameProperties(cnctn);
    }

    @Override
    public boolean isServerLocal() throws SQLException {
        return con.isServerLocal();
    }

    @Override
    public int getSessionMaxRows() {
        return con.getSessionMaxRows();
    }

    @Override
    public void setSessionMaxRows(int i) throws SQLException {
        con.setSessionMaxRows(i);
    }

    @Override
    public void setSchema(String string) throws SQLException {
        con.setSchema(string);
    }

    @Override
    public String getSchema() throws SQLException {
        return con.getSchema();
    }

    @Override
    public void abort(Executor exctr) throws SQLException {
        con.abort(exctr);
    }

    @Override
    public void setNetworkTimeout(Executor exctr, int i) throws SQLException {
        con.setNetworkTimeout(exctr, i);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return con.getNetworkTimeout();
    }

    @Override
    public void abortInternal() throws SQLException {
        con.abortInternal();
    }

    @Override
    public void checkClosed() throws SQLException {
        con.checkClosed();
    }

    @Override
    public Object getConnectionMutex() {
        return con.getConnectionMutex();
    }

    @Override
    public boolean isProxySet() {
        return con.isProxySet();
    }

    @Override
    public void createNewIO(boolean bln) throws SQLException {
        con.createNewIO(bln);
    }

    @Override
    public void dumpTestcaseQuery(String string) {
        con.dumpTestcaseQuery(string);
    }

    @Override
    public com.mysql.jdbc.Connection duplicate() throws SQLException {
        return con.duplicate();
    }

    @Override
    public ResultSetInternalMethods execSQL(StatementImpl si, String string, int i, Buffer buffer, int i1, int i2, boolean bln, String string1, Field[] fields) throws SQLException {
        return con.execSQL(si, string, i, buffer, i1, i2, bln, string1, fields);
    }

    @Override
    public ResultSetInternalMethods execSQL(StatementImpl si, String string, int i, Buffer buffer, int i1, int i2, boolean bln, String string1, Field[] fields, boolean bln1) throws SQLException {
        return con.execSQL(si, string, i, buffer, i1, i2, bln, string1, fields, bln1);
    }

    @Override
    public String extractSqlFromPacket(String string, Buffer buffer, int i) throws SQLException {
        return con.extractSqlFromPacket(string, buffer, i);
    }

    @Override
    public StringBuilder generateConnectionCommentBlock(StringBuilder sb) {
        return con.generateConnectionCommentBlock(sb);
    }

    @Override
    public int getActiveStatementCount() {
        return con.getActiveStatementCount();
    }

    @Override
    public int getAutoIncrementIncrement() {
        return con.getAutoIncrementIncrement();
    }

    @Override
    public CachedResultSetMetaData getCachedMetaData(String string) {
        return con.getCachedMetaData(string);
    }

    @Override
    public Calendar getCalendarInstanceForSessionOrNew() {
        return con.getCalendarInstanceForSessionOrNew();
    }

    @Override
    public Timer getCancelTimer() {
        return con.getCancelTimer();
    }

    @Override
    public String getCharacterSetMetadata() {
        return con.getCharacterSetMetadata();
    }

    @Override
    public SingleByteCharsetConverter getCharsetConverter(String string) throws SQLException {
        return con.getCharsetConverter(string);
    }

    @Override
    public String getCharsetNameForIndex(int i) throws SQLException {
        return con.getCharsetNameForIndex(i);
    }

    @Override
    public String getEncodingForIndex(int i) throws SQLException {
        return con.getEncodingForIndex(i);
    }

    @Override
    public TimeZone getDefaultTimeZone() {
        return con.getDefaultTimeZone();
    }

    @Override
    public String getErrorMessageEncoding() {
        return con.getErrorMessageEncoding();
    }

    @Override
    public ExceptionInterceptor getExceptionInterceptor() {
        return con.getExceptionInterceptor();
    }

    @Override
    public String getHost() {
        return con.getHost();
    }

    @Override
    public String getHostPortPair() {
        return con.getHostPortPair();
    }

    @Override
    public long getId() {
        return con.getId();
    }

    @Override
    public long getIdleFor() {
        return con.getIdleFor();
    }

    @Override
    public MysqlIO getIO() throws SQLException {
        return con.getIO();
    }

    @Override
    public Log getLog() throws SQLException {
        return con.getLog();
    }

    @Override
    public int getMaxBytesPerChar(String string) throws SQLException {
        return con.getMaxBytesPerChar(string);
    }

    @Override
    public int getMaxBytesPerChar(Integer intgr, String string) throws SQLException {
        return con.getMaxBytesPerChar(intgr, string);
    }

    @Override
    public Statement getMetadataSafeStatement() throws SQLException {
        return con.getMetadataSafeStatement();
    }

    @Override
    public int getNetBufferLength() {
        return con.getNetBufferLength();
    }

    @Override
    public Properties getProperties() {
        return con.getProperties();
    }

    @Override
    public boolean getRequiresEscapingEncoder() {
        return con.getRequiresEscapingEncoder();
    }

    @Override
    public String getServerCharset() {
        return con.getServerCharset();
    }

    @Override
    public int getServerMajorVersion() {
        return con.getServerMajorVersion();
    }

    @Override
    public int getServerMinorVersion() {
        return con.getServerMinorVersion();
    }

    @Override
    public int getServerSubMinorVersion() {
        return con.getServerSubMinorVersion();
    }

    @Override
    public TimeZone getServerTimezoneTZ() {
        return con.getServerTimezoneTZ();
    }

    @Override
    public String getServerVariable(String string) {
        return con.getServerVariable(string);
    }

    @Override
    public String getServerVersion() {
        return con.getServerVersion();
    }

    @Override
    public Calendar getSessionLockedCalendar() {
        return con.getSessionLockedCalendar();
    }

    @Override
    public String getStatementComment() {
        return con.getStatementComment();
    }

    @Override
    public List<StatementInterceptorV2> getStatementInterceptorsInstances() {
        return con.getStatementInterceptorsInstances();
    }

    @Override
    public String getURL() {
        return con.getURL();
    }

    @Override
    public String getUser() {
        return con.getUser();
    }

    @Override
    public Calendar getUtcCalendar() {
        return con.getUtcCalendar();
    }

    @Override
    public void incrementNumberOfPreparedExecutes() {
        con.incrementNumberOfPreparedExecutes();
    }

    @Override
    public void incrementNumberOfPrepares() {
        con.incrementNumberOfPrepares();
    }

    @Override
    public void incrementNumberOfResultSetsCreated() {
        con.incrementNumberOfResultSetsCreated();
    }

    @Override
    public void initializeResultsMetadataFromCache(String string, CachedResultSetMetaData crsmd, ResultSetInternalMethods rsim) throws SQLException {
        con.initializeResultsMetadataFromCache(string, crsmd, rsim);
    }

    @Override
    public void initializeSafeStatementInterceptors() throws SQLException {
        con.initializeSafeStatementInterceptors();
    }

    @Override
    public boolean isAbonormallyLongQuery(long l) {
        return con.isAbonormallyLongQuery(l);
    }

    @Override
    public boolean isClientTzUTC() {
        return con.isClientTzUTC();
    }

    @Override
    public boolean isCursorFetchEnabled() throws SQLException {
        return con.isCursorFetchEnabled();
    }

    @Override
    public boolean isReadInfoMsgEnabled() {
        return con.isReadInfoMsgEnabled();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return con.isReadOnly();
    }

    @Override
    public boolean isReadOnly(boolean bln) throws SQLException {
        return con.isReadOnly(bln);
    }

    @Override
    public boolean isRunningOnJDK13() {
        return con.isRunningOnJDK13();
    }

    @Override
    public boolean isServerTzUTC() {
        return con.isServerTzUTC();
    }

    @Override
    public boolean lowerCaseTableNames() {
        return con.lowerCaseTableNames();
    }

    @Override
    public void pingInternal(boolean bln, int i) throws SQLException {
        con.pingInternal(bln, i);
    }

    @Override
    public void realClose(boolean bln, boolean bln1, boolean bln2, Throwable thrwbl) throws SQLException {
        con.realClose(bln, bln1, bln2, thrwbl);
    }

    @Override
    public void recachePreparedStatement(ServerPreparedStatement sps) throws SQLException {
        con.recachePreparedStatement(sps);
    }

    @Override
    public void decachePreparedStatement(ServerPreparedStatement sps) throws SQLException {
        con.decachePreparedStatement(sps);
    }

    @Override
    public void registerQueryExecutionTime(long l) {
        con.registerQueryExecutionTime(l);
    }

    @Override
    public void registerStatement(com.mysql.jdbc.Statement stmnt) {
        con.registerStatement(stmnt);
    }

    @Override
    public void reportNumberOfTablesAccessed(int i) {
        con.reportNumberOfTablesAccessed(i);
    }

    @Override
    public boolean serverSupportsConvertFn() throws SQLException {
        return con.serverSupportsConvertFn();
    }

    @Override
    public void setProxy(MySQLConnection msqlc) {
        con.setProxy(msqlc);
    }

    @Override
    public void setReadInfoMsgEnabled(boolean bln) {
        con.setReadInfoMsgEnabled(bln);
    }

    @Override
    public void setReadOnlyInternal(boolean bln) throws SQLException {
        con.setReadOnlyInternal(bln);
    }

    @Override
    public void shutdownServer() throws SQLException {
        con.shutdownServer();
    }

    @Override
    public boolean storesLowerCaseTableName() {
        return con.storesLowerCaseTableName();
    }

    @Override
    public void throwConnectionClosedException() throws SQLException {
        con.throwConnectionClosedException();
    }

    @Override
    public void transactionBegun() throws SQLException {
        con.transactionBegun();
    }

    @Override
    public void transactionCompleted() throws SQLException {
        con.transactionCompleted();
    }

    @Override
    public void unregisterStatement(com.mysql.jdbc.Statement stmnt) {
        con.unregisterStatement(stmnt);
    }

    @Override
    public void unSafeStatementInterceptors() throws SQLException {
        con.unSafeStatementInterceptors();
    }

    @Override
    public boolean useAnsiQuotedIdentifiers() {
        return con.useAnsiQuotedIdentifiers();
    }

    @Override
    public String getConnectionAttributes() throws SQLException {
        return con.getConnectionAttributes();
    }

    @Override
    public MySQLConnection getLoadBalanceSafeProxy() {
        return con.getLoadBalanceSafeProxy();
    }

    @Override
    public MySQLConnection getMultiHostSafeProxy() {
        return con.getMultiHostSafeProxy();
    }

    @Override
    public MySQLConnection getActiveMySQLConnection() {
        return con.getActiveMySQLConnection();
    }

    @Override
    public ProfilerEventHandler getProfilerEventHandlerInstance() {
        return con.getProfilerEventHandlerInstance();
    }

    @Override
    public void setProfilerEventHandlerInstance(ProfilerEventHandler peh) {
        con.setProfilerEventHandlerInstance(peh);
    }

    @Override
    public boolean isServerTruncatesFracSecs() {
        return con.isServerTruncatesFracSecs();
    }

    @Override
    public String getQueryTimingUnits() {
        return con.getQueryTimingUnits();
    }
}
