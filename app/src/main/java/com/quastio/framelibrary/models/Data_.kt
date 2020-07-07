package com.quastio.framelibrary.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Data_ (

    @SerializedName("approved_at_utc")
    @Expose
    private val approvedAtUtc: Any,

    @SerializedName("subreddit")
    @Expose
    private val subreddit: String,

    @SerializedName("selftext")
    @Expose
    private val selftext: String,

    @SerializedName("author_fullname")
    @Expose
    private val authorFullname: String,

    @SerializedName("saved")
    @Expose
    private val saved: Boolean,

    @SerializedName("mod_reason_title")
    @Expose
    private val modReasonTitle: Any,

    @SerializedName("gilded")
    @Expose
    private val gilded: Int,

    @SerializedName("clicked")
    @Expose
    private val clicked: Boolean,

    @SerializedName("title")
    @Expose
    private val title: String,


    @SerializedName("subreddit_name_prefixed")
    @Expose
    private val subredditNamePrefixed: String,

    @SerializedName("hidden")
    @Expose
    private val hidden: Boolean,

    @SerializedName("pwls")
    @Expose
    private val pwls: Int,

    @SerializedName("link_flair_css_class")
    @Expose
    private val linkFlairCssClass: String,

    @SerializedName("downs")
    @Expose
    private val downs: Int,

    @SerializedName("thumbnail_height")
    @Expose
    private val thumbnailHeight: Int,

    @SerializedName("top_awarded_type")
    @Expose
    private val topAwardedType: Any,

    @SerializedName("hide_score")
    @Expose
    private val hideScore: Boolean,

    @SerializedName("name")
    @Expose
    private val name: String,

    @SerializedName("quarantine")
    @Expose
    private val quarantine: Boolean,

    @SerializedName("link_flair_text_color")
    @Expose
    private val linkFlairTextColor: String,

    @SerializedName("upvote_ratio")
    @Expose
    private val upvoteRatio: Double,

    @SerializedName("author_flair_background_color")
    @Expose
    private val authorFlairBackgroundColor: Any,

    @SerializedName("subreddit_type")
    @Expose
    private val subredditType: String,

    @SerializedName("ups")
    @Expose
    private val ups: Int,

    @SerializedName("total_awards_received")
    @Expose
    private val totalAwardsReceived: Int,



    @SerializedName("thumbnail_width")
    @Expose
    private val thumbnailWidth: Int,

    @SerializedName("author_flair_template_id")
    @Expose
    private val authorFlairTemplateId: Any,

    @SerializedName("is_original_content")
    @Expose
    private val isOriginalContent: Boolean,

    @SerializedName("user_reports")
    @Expose
    private val userReports: List<Any>,

    @SerializedName("secure_media")
    @Expose
    private val secureMedia: Any,

    @SerializedName("is_reddit_media_domain")
    @Expose
    private val isRedditMediaDomain: Boolean,

    @SerializedName("is_meta")
    @Expose
    private val isMeta: Boolean,

    @SerializedName("category")
    @Expose
    private val category: Any,



    @SerializedName("link_flair_text")
    @Expose
    private val linkFlairText: String,

    @SerializedName("can_mod_post")
    @Expose
    private val canModPost: Boolean,

    @SerializedName("score")
    @Expose
    private val score: Int,

    @SerializedName("approved_by")
    @Expose
    private val approvedBy: Any,

    @SerializedName("author_premium")
    @Expose
    private val authorPremium: Boolean,

    @SerializedName("thumbnail")
    @Expose
     val thumbnail: String,

    @SerializedName("edited")
    @Expose
    private val edited: Boolean,

    @SerializedName("author_flair_css_class")
    @Expose
    private val authorFlairCssClass: Any,

    @SerializedName("author_flair_richtext")
    @Expose
    private val authorFlairRichtext: List<Any>,



    @SerializedName("post_hint")
    @Expose
    private val postHint: String,

    @SerializedName("content_categories")
    @Expose
    private val contentCategories: Any,

    @SerializedName("is_self")
    @Expose
    private val isSelf: Boolean,

    @SerializedName("mod_note")
    @Expose
    private val modNote: Any,



    @SerializedName("created")
    @Expose
    private val created: Int,

    @SerializedName("link_flair_type")
    @Expose
    private val linkFlairType: String,

    @SerializedName("wls")
    @Expose
    private val wls: Int,

    @SerializedName("removed_by_category")
    @Expose
    private val removedByCategory: Any,

    @SerializedName("banned_by")
    @Expose
    private val bannedBy: Any,

    @SerializedName("author_flair_type")
    @Expose
    private val authorFlairType: String,

    @SerializedName("domain")
    @Expose
    private val domain: String,

    @SerializedName("allow_live_comments")
    @Expose
    private val allowLiveComments: Boolean,

    @SerializedName("selftext_html")
    @Expose
    private val selftextHtml: Any,

    @SerializedName("likes")
    @Expose
    private val likes: Any,

    @SerializedName("suggested_sort")
    @Expose
    private val suggestedSort: Any,

    @SerializedName("banned_at_utc")
    @Expose
    private val bannedAtUtc: Any,

    @SerializedName("url_overridden_by_dest")
    @Expose
    private val urlOverriddenByDest: String,

    @SerializedName("view_count")
    @Expose
    private val viewCount: Any,

    @SerializedName("archived")
    @Expose
    private val archived: Boolean,

    @SerializedName("no_follow")
    @Expose
    private val noFollow: Boolean,

    @SerializedName("is_crosspostable")
    @Expose
    private val isCrosspostable: Boolean,

    @SerializedName("pinned")
    @Expose
    private val pinned: Boolean,

    @SerializedName("over_18")
    @Expose
    private val over18: Boolean,



    @SerializedName("all_awardings")
    @Expose
    private val allAwardings: List<Any>,

    @SerializedName("awarders")
    @Expose
    private val awarders: List<Any>,

    @SerializedName("media_only")
    @Expose
    private val mediaOnly: Boolean,

    @SerializedName("link_flair_template_id")
    @Expose
    private val linkFlairTemplateId: String,

    @SerializedName("can_gild")
    @Expose
    private val canGild: Boolean,

    @SerializedName("spoiler")
    @Expose
    private val spoiler: Boolean,

    @SerializedName("locked")
    @Expose
    private val locked: Boolean,

    @SerializedName("author_flair_text")
    @Expose
    private val authorFlairText: Any,

    @SerializedName("treatment_tags")
    @Expose
    private val treatmentTags: List<Any>,

    @SerializedName("visited")
    @Expose
    private val visited: Boolean,

    @SerializedName("removed_by")
    @Expose
    private val removedBy: Any,

    @SerializedName("num_reports")
    @Expose
    private val numReports: Any,

    @SerializedName("distinguished")
    @Expose
    private val distinguished: Any,

    @SerializedName("subreddit_id")
    @Expose
    private val subredditId: String,

    @SerializedName("mod_reason_by")
    @Expose
    private val modReasonBy: Any,

    @SerializedName("removal_reason")
    @Expose
    private val removalReason: Any,

    @SerializedName("link_flair_background_color")
    @Expose
    private val linkFlairBackgroundColor: String,

    @SerializedName("id")
    @Expose
    private val id: String,

    @SerializedName("is_robot_indexable")
    @Expose
    private val isRobotIndexable: Boolean,

    @SerializedName("report_reasons")
    @Expose
    private val reportReasons: Any,

    @SerializedName("author")
    @Expose
    private val author: String,

    @SerializedName("discussion_type")
    @Expose
    private val discussionType: Any,

    @SerializedName("num_comments")
    @Expose
    private val numComments: Int,

    @SerializedName("send_replies")
    @Expose
    private val sendReplies: Boolean,

    @SerializedName("whitelist_status")
    @Expose
    private val whitelistStatus: String,

    @SerializedName("contest_mode")
    @Expose
    private val contestMode: Boolean,

    @SerializedName("mod_reports")
    @Expose
    private val modReports: List<Any>,

    @SerializedName("author_patreon_flair")
    @Expose
    private val authorPatreonFlair: Boolean,

    @SerializedName("crosspost_parent")
    @Expose
    private val crosspostParent: String,

    @SerializedName("author_flair_text_color")
    @Expose
    private val authorFlairTextColor: Any,

    @SerializedName("permalink")
    @Expose
    private val permalink: String,

    @SerializedName("parent_whitelist_status")
    @Expose
    private val parentWhitelistStatus: String,

    @SerializedName("stickied")
    @Expose
    private val stickied: Boolean,

    @SerializedName("url")
    @Expose
    private val url: String,

    @SerializedName("subreddit_subscribers")
    @Expose
    private val subredditSubscribers: Int,

    @SerializedName("created_utc")
    @Expose
    private val createdUtc: Int,

    @SerializedName("num_crossposts")
    @Expose
    private val numCrossposts: Int,

    @SerializedName("media")
    @Expose
    private val media: Any,

    @SerializedName("is_video")
    @Expose
    private val isVideo: Boolean
){

}