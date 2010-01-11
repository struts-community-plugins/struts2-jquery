/**
 * "Yet Another Multicolumn Layout" - (X)HTML/CSS Framework
 *
 * (en) Workaround for Webkit browser to fix focus problems when using skiplinks
 * (de) Workaround für Webkit-Browser, um den Focus zu korrigieren, bei Verwendung von Skiplinks
 *
 * @note			inspired by Paul Ratcliffe's article 
 *					http://www.communis.co.uk/blog/2009-06-02-skip-links-chrome-safari-and-added-wai-aria
 *
 * @copyright       Copyright 2005-2009, Dirk Jesse
 * @license         CC-A 2.0 (http://creativecommons.org/licenses/by/2.0/),
 *                  YAML-C (http://www.yaml.de/en/license/license-conditions.html)
 * @link            http://www.yaml.de
 * @package         yaml
 * @version         3.2
 * @revision        $Revision: 430 $
 * @lastmodified    $Date: 2009-10-27 21:15:57 +0100 (Di, 27. Okt 2009) $
 */
 
var is_webkit = navigator.userAgent.toLowerCase().indexOf('webkit') > -1;

if(is_webkit) 
{
	var i;
	var skiplinks = []
	
	if ( document.getElementsByClassName !== undefined) {
		skiplinks = document.getElementsByClassName('skip');

		for (i=0; i<skiplinks.length; i++) {
			var target = skiplinks[i].href.substr(skiplinks[i].href.indexOf('#')+1);
			var targetElement = document.getElementById(target);
	
			targetElement.href = '#'+target;
			targetElement.setAttribute("tabindex", "0");
	
			skiplinks[i].setAttribute("onclick", "document.getElementById('"+target+"').focus();");
		}
	}	
}