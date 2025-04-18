ALTER TABLE `wp_comments` CHANGE `comment_post_ID` `comment_post_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `wp_comments` CHANGE `comment_ID` `comment_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0';
ALTER TABLE `wp_comments` CHANGE `comment_author_IP` `comment_author_ip` VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '';

CREATE TABLE `wp_commentmeta` (
  `meta_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `meta_key` varchar(255) DEFAULT NULL,
  `meta_value` longtext,
  PRIMARY KEY (`meta_id`),
  KEY `comment_id` (`comment_id`),
  KEY `meta_key` (`meta_key`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

