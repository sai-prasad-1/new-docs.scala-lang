//Contributors widget
// see https://stackoverflow.com/a/19200303/4496364
$(document).ready(function () {
    let githubApiUrl = 'https://api.github.com/repos/scala/docs.scala-lang/commits';
    let identiconsUrl = 'https://github.com/identicons';
    /* - we need to transform "/tour/basics.html" to "_ba/tour/basics.md"
     * - some files aren't prefixed with underscore, see rootFiles
     * - some files are placed in _overviews but rendered to its folder, see overviewsFolders
     */
  
    let rootFiles = ['getting-started', 'learn', 'glossary'];
    let overviewsFolders = ['FAQ', 'cheatsheets', 'collections', 'compiler-options',
      'core', 'jdk-compatibility', 'macros', 'parallel-collections',
      'plugins', 'quasiquotes', 'reflection',
      'repl', 'scaladoc', 'tutorials'
    ];
  
    let thisPageUrl = window.location.pathname;
    // chop off beginning slash and ending .html
    thisPageUrl = thisPageUrl.substring(1, thisPageUrl.lastIndexOf('.'));
    let isRootFile = rootFiles.some(rf => thisPageUrl.startsWith(rf));
    let isInOverviewsFolder = overviewsFolders.some(of => thisPageUrl.startsWith(of));
    if(isRootFile) {
      thisPageUrl = thisPageUrl + '.md';
    } else if(thisPageUrl.indexOf("tutorials/FAQ/") == 0) {
      thisPageUrl = '_overviews/' + thisPageUrl.substring("tutorials/".length) + '.md';
    } else if(isInOverviewsFolder) {
      thisPageUrl = '_overviews/'+ thisPageUrl + '.md';
    } else if (thisPageUrl.startsWith('scala3/book')) {
      thisPageUrl = '_overviews/scala3-book/' + thisPageUrl.substring("scala3/book/".length) + '.md';
    } else {
      thisPageUrl = '_' + thisPageUrl + '.md';
    }
  
    let url = githubApiUrl + '?path=' + thisPageUrl;
    $.get(url, function (data, status) {
      if(!data || data.length < 1) {
        $('.content-contributors').html(''); // clear content
        return false; // break
      }
      let contributorsUnique = [];
      data.forEach(commit => {
        // add if not already in array
        let addedToList = contributorsUnique.find(c => {
          let matches = c.authorName == commit.commit.author.name;
          if (!matches && commit.author) {
            matches = c.authorName == commit.author.login;
          }
          return matches;
        });
  
        if (!addedToList) {
          // first set fallback properties
          let authorName = commit.commit.author.name;
          let authorLink = '';
          let authorImageLink = identiconsUrl + '/' + commit.commit.author.name + '.png';
          // if author present, fill these preferably
          if (commit.author) {
            authorName = commit.author.login;
            authorLink = commit.author.html_url;
            authorImageLink = commit.author.avatar_url;
          }
          contributorsUnique.push({
            'authorName': authorName,
            'authorLink': authorLink,
            'authorImageLink': authorImageLink
          });
        }
      });
  
      let contributorsHtml = '';
      contributorsUnique.forEach(contributor => {
        let contributorHtml = '<div>';
        contributorHtml += '<img src="' + contributor.authorImageLink + '">';
        if (contributor.authorLink)
          contributorHtml += '<a href="' + contributor.authorLink + '">' + contributor.authorName + '</a>';
        else
          contributorHtml += '<a>' + contributor.authorName + '</a>';
        contributorHtml += '</div>';
        contributorsHtml += contributorHtml;
      });
      $('#contributors').html(contributorsHtml);
    });
  });