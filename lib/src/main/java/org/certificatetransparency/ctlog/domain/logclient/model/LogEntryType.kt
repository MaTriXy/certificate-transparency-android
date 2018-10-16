package org.certificatetransparency.ctlog.domain.logclient.model

/**
 * @property UNKNOWN_ENTRY_TYPE Not part of the I-D, and outside the valid range.
 */
enum class LogEntryType(val number: Int) {
    X509_ENTRY(0),
    PRE_CERTIFICATE_ENTRY(1),
    UNKNOWN_ENTRY_TYPE(65536);

    companion object {
        fun forNumber(number: Int) = LogEntryType.values().firstOrNull { it.number == number } ?: UNKNOWN_ENTRY_TYPE
    }
}