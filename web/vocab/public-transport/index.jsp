<%-- 
    Document   : newjsp
    Created on : Nov 29, 2011, 1:03:40 AM
    Author     : Jiří Mašek <masekji4@fit.cvut.cz>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN" "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en"
      xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
      xmlns:pubtrans="http://dpp-news.appspot.com/vocab/public-transport#"
      xmlns:vs="http://www.w3.org/2003/06/sw-vocab-status/ns#"
      xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#"
      xmlns:owl="http://www.w3.org/2002/07/owl#"
      xmlns:dct="http://purl.org/dc/terms/"
      xmlns:dc="http://purl.org/dc/elements/1.1/">
    <head>
        <title>PubTrans Vocabulary Specification</title>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <link href="http://xmlns.com/xmlns-style.css" rel="stylesheet"  type="text/css" />
        <link href="http://dpp-news.appspot.com/vocab/public-transport/style.css" rel="stylesheet"  type="text/css" />
        <link href="http://dpp-news.appspot.com/vocab/public-transport/index.rdf" rel="alternate"  type="application/rdf+xml" />
    </head>

    <body>
        <h1>PubTrans Vocabulary Specification 0.1<br /></h1>

        <h2>Namespace Document 28 November 2011</h2>

        <dl>
            <dt>This version:</dt>
            <dd><a href="http://dpp-news.appspot.com/vocab/public-transport/20111128.html">http://dpp-news.appspot.com/vocab/public-transport/20111128.html</a> (<a href="http://dpp-news.appspot.com/vocab/public-transport/20111128.rdf">rdf</a>)</dd>

            <dt>Latest version:</dt>
            <dd><a href="http://dpp-news.appspot.com/vocab/public-transport/">http://dpp-news.appspot.com/vocab/public-transport/</a> (<a href="http://dpp-news.appspot.com/vocab/public-transport/index.rdf">rdf</a>)</dd>
            
            <dt>Authors:</dt>
            <dd><a href="mailto:masekji4@gmail.com">Jiří Mašek</a></dd>
        </dl>

        <p class="copyright">Copyright &#169; 2011 Jiří Mašek</p>
        
        <div about=""  resource="http://www.w3.org/TR/rdfa-syntax"  rel="dct:conformsTo" />

            <!-- Creative Commons License -->
            <p>This work is licensed under a <a  rel="license" href="http://creativecommons.org/licenses/by/1.0/">Creative Commons Attribution License</a>. This copyright applies to the <em>PubTrans Vocabulary Specification</em> and accompanying documentation in RDF. Regarding underlying technology, PubTrans uses W3C's <a href="http://www.w3.org/RDF/">RDF</a> technology, an open Web standard that can be freely used by anyone.</p>

        </div>

        <hr />


        <h2 id="sec-status">Abstract</h2>

        <p>This specification describes the PubTrans language, defined as a dictionary of named properties and classes using W3C's RDF technology.</p>

        <p>PubTrans is a project…</p>

        <div class="status">
            <h2>Status of This Document</h2>

            <p>PubTrans has been evolving…</p>

            <p>The PubTrans specification is produced as part of the <a href="http://dppnews.googlecode.com/">DPPnews project</a>, to provide authoritative documentation of the contents, status and purpose of the RDF/XML vocabulary and document formats known informally as 'PubTrans'.</p>

            <p>This document is created by the <a href="index.rdf">RDFS/OWL</a> machine-readable PubTrans ontology. An RDF/XML encoding of the specification is available by <a href="http://dpp-news.appspot.com/vocab/public-transport/index.rdf">direct link</a>. The HTML specification no longer embeds the RDF/XML markup; however an experimental subset of the RDF is included in this document using RDFa notation.</p>
        </div>

        <h2 id="sec-toc">Table of Contents</h2>

        <ul>
            <li><a href="#sec-crossref">PubTrans cross-reference: Listing PubTrans Classes, Properties and Individuals</a></li>
        </ul>

        <h2 id="sec-crossref">PubTrans cross-reference: Listing PubTrans Classes, Properties and Individuals</h2>

        <p>PubTrans introduces the following classes, properties and individuals. A machine-friendly version is also available in <a href="http://dpp-news.appspot.com/vocab/public-transport/index.rdf">RDF/XML</a>.</p>

        <!-- the following is the script-generated list of classes and properties -->


        <!-- this is the a-z listing -->
        <div class="azlist">
            <p>Classes: | <a href="#Incident">Incident</a> |  <a href="#Line">Line</a> |  <a href="#ModeOfTransport">ModeOfTransport</a> |</p>
            <p>Properties: | <a href="#affectsLine">affectsLine</a> |  <a href="#isExpectedToBeSolvedAt">isExpectedToBeSolvedAt</a> |  <a href="#modeOfTransport">modeOfTransport</a> |  <a href="#number">number</a> |  <a href="#originatedAt">originatedAt</a> |  <a href="#stretch">stretch</a> |  <a href="#type">type</a> |  <a href="#wasSolvedAt">wasSolvedAt</a> |</p>
            <p>Individuals: | <a href="#Bus">Bus</a> |  <a href="#Ferry">Ferry</a> |  <a href="#Funicular">Funicular</a> |  <a href="#Subway">Subway</a> |  <a href="#Tram">Tram</a> |</p>
        </div>

        <!-- and this is the bulk of the vocab descriptions -->
        <div class="termlist">
            <h3>Classes and Properties (full detail)</h3>
            
            <div class='termdetails'><br />

                <h2>Classes</h2>
                
                <div class="specterm classterm " id="Incident" about="http://dpp-news.appspot.com/vocab/public-transport#Incident" typeof="rdfs:Class">
                    
                    <h3>Class: pubtrans:Incident</h3> 
                    
                    <em>Incident</em> - An incident in public transport. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Properties include:</th>
                            
                            <td>
                                <a href="#affectsLine">affectsLine</a>
                                <a href="#isExpectedToBeSolvedAt">isExpectedToBeSolvedAt</a>
                                <a href="#originatedAt">originatedAt</a>
                                <a href="#stretch">stretch</a>
                                <a href="#type">type</a>
                                <a href="#wasSolvedAt">wasSolvedAt</a>
                            </td>
                        </tr>
                        
                        <tr>
                            <th>Used with:</th>
                            
                            <td>
                                <a href="#affectsLine">affectsLine</a>
                            </td>
                        </tr>
                    </table>

                    <!-- todo: write rdfs:domain statements for those properties -->

                    <p style="float: right; font-size: small;">[<a href="#Incident">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm classterm " id="Line" about="http://dpp-news.appspot.com/vocab/public-transport#Line" typeof="rdfs:Class">
                    
                    <h3>Class: pubtrans:Line</h3> 
                    
                    <em>Line</em> - A stable signed route in public transport.<br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Properties include:</th>
                            
                            <td>
                                <a href="#modeOfTransport">modeOfTransport</a>
                                <a href="#number">number</a>
                            </td>
                        </tr>
                        
                        <tr>
                            <th>Used with:</th>
                            
                            <td>
                                <a href="#affectsLine">affectsLine</a>
                                <a href="#modeOfTransport">modeOfTransport</a>
                            </td>
                        </tr>
                    </table>

                    <!-- todo: write rdfs:domain statements for those properties -->

                    <p style="float: right; font-size: small;">[<a href="#Line">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm classterm " id="ModeOfTransport" about="http://dpp-news.appspot.com/vocab/public-transport#ModeOfTransport" typeof="rdfs:Class">
                    
                    <h3>Class: pubtrans:ModeOfTransport</h3> 
                    
                    <em>ModeOfTransport</em> - A mode of transport. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Used with:</th>
                            
                            <td>
                                <a href="#modeOfTransport">modeOfTransport</a>
                            </td>
                        </tr>
                    </table>

                    <!-- todo: write rdfs:domain statements for those properties -->

                    <p style="float: right; font-size: small;">[<a href="#ModeOfTransport">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <h2>Properties</h2>
                
                <div class="specterm propertyterm " id="affectsLine" about="http://dpp-news.appspot.com/vocab/public-transport#affectsLine" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:affectsLine</h3> 
                    
                    <em>affectsLine</em> - A line affected by this incident. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                        
                        <tr>
                            <th>Range:</th>
                            <td> every value of this property is a  <span rel="rdfs:range" href="http://dpp-news.appspot.com/vocab/public-transport#Line"><a href="#Line">Line</a></span></td>
                        </tr>
                    </table>

                    <p style="float: right; font-size: small;">[<a href="#affectsLine">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="isExpectedToBeSolvedAt" about="http://dpp-news.appspot.com/vocab/public-transport#isExpectedToBeSolvedAt" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:isExpectedToBeSolvedAt</h3> 
                    
                    <em>isExpectedToBeSolvedAt</em> - Expected time for solving an incident. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#isExpectedToBeSolvedAt'>isExpectedToBeSolvedAt</a></code> of some incident is a <span rel="rdf:datatype" href="http://www.w3.org/2001/XMLSchema#dateTime">datetime</a>.</p>

                    <p style="float: right; font-size: small;">[<a href="#isExpectedToBeSolvedAt">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="modeOfTransport" about="http://dpp-news.appspot.com/vocab/public-transport#modeOfTransport" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:modeOfTransport</h3> 
                    
                    <em>modeOfTransport</em> - A mode of transport which realize some line. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Line"><a href="#Line">Line</a></span></td>
                        </tr>
                        
                        <tr>
                            <th>Range:</th>
                            <td> every value of this property is a  <span rel="rdfs:range" href="http://dpp-news.appspot.com/vocab/public-transport#ModeOfTransport"><a href="#ModeOfTransport">ModeOfTransport</a></span></td>
                        </tr>
                    </table>

                    <p style="float: right; font-size: small;">[<a href="#modeOfTransport">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="number" about="http://dpp-news.appspot.com/vocab/public-transport#number" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:number</h3> 
                    
                    <em>number</em> - A number for some line. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Line"><a href="#Line">Line</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#number'>number</a></code> of some line is a simple textual string.</p>

                    <p style="float: right; font-size: small;">[<a href="#number">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="originatedAt" about="http://dpp-news.appspot.com/vocab/public-transport#originatedAt" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:originatedAt</h3> 
                    
                    <em>originatedAt</em> - Time of origin of an incident.. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#originatedAt'>originatedAt</a></code> of some incident is a <span rel="rdf:datatype" href="http://www.w3.org/2001/XMLSchema#dateTime">datetime</a>.</p>

                    <p style="float: right; font-size: small;">[<a href="#originatedAt">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="stretch" about="http://dpp-news.appspot.com/vocab/public-transport#stretch" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:stretch</h3> 
                    
                    <em>stretch</em> - A stretch which is affected by an incident. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#stretch'>stretch</a></code> of some incident is a simple textual string.</p>

                    <p style="float: right; font-size: small;">[<a href="#stretch">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="type" about="http://dpp-news.appspot.com/vocab/public-transport#type" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:type</h3> 
                    
                    <em>type</em> - A type of an incident. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#type'>type</a></code> of some incident is a simple textual string.</p>

                    <p style="float: right; font-size: small;">[<a href="#type">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm propertyterm " id="wasSolvedAt" about="http://dpp-news.appspot.com/vocab/public-transport#wasSolvedAt" typeof="rdf:Property">
                    
                    <h3>Property: pubtrans:wasSolvedAt</h3> 
                    
                    <em>wasSolvedAt</em> - A time of solving an incident. <br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Domain:</th>
                            <td>having this property implies being a  <span rel="rdfs:domain" href="http://dpp-news.appspot.com/vocab/public-transport#Incident"><a href="#Incident">Incident</a></span></td>
                        </tr>
                    </table>
                    
                    <p>The <code><a href='#wasSolvedAt'>wasSolvedAt</a></code> of some incident is a <span rel="rdf:datatype" href="http://www.w3.org/2001/XMLSchema#dateTime">datetime</a>.</p>

                    <p style="float: right; font-size: small;">[<a href="#wasSolvedAt">#</a>]  [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <h2>Individuals</h2>
                
                <div class="specterm individualterm " id="Bus" about="http://dpp-news.appspot.com/vocab/public-transport#Bus" typeof="rdfs:Resource">
                    
                    <h3>Individual: pubtrans:Bus</h3> 
                    
                    <em>Bus</em> - A homepage for some thing.<br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Type:</th>
                            <td><a href="#ModeOfTransport">ModeOfTransport</a></td>
                        </tr>
                    </table>
                    
                    <p>
                        The <code><a href='#Bus'>Bus</a></code> individual represents transport realized by buses.
                    </p>


                    <p style="float: right; font-size: small;">[<a href="#Bus">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm individualterm " id="Ferry" about="http://dpp-news.appspot.com/vocab/public-transport#Ferry" typeof="rdfs:Resource">
                    
                    <h3>Individual: pubtrans:Ferry</h3> 
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Type:</th>
                            <td><a href="#ModeOfTransport">ModeOfTransport</a></td>
                        </tr>
                    </table>
                    
                    <p>
                        The <code><a href='#Ferry'>Ferry</a></code> individual represents transport realized by ferries.
                    </p>

                    <p style="float: right; font-size: small;">[<a href="#Ferry">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm individualterm " id="Funicular" about="http://dpp-news.appspot.com/vocab/public-transport#Funicular" typeof="rdfs:Resource">
                    
                    <h3>Individual: pubtrans:Funicular</h3> 
                    
                    <em>Funicular</em> - A funicular.<br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Type:</th>
                            <td><a href="#ModeOfTransport">ModeOfTransport</a></td>
                        </tr>
                    </table>
                    
                    <p>
                        The <code><a href='#Funicular'>Funicular</a></code> individual represents transport realized by funicular.
                    </p>

                    <p style="float: right; font-size: small;">[<a href="#Funicular">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm individualterm " id="Subway" about="http://dpp-news.appspot.com/vocab/public-transport#Subway" typeof="rdfs:Resource">
                    
                    <h3>Individual: pubtrans:Subway</h3> 
                    
                    <em>Subway</em> - A subway.<br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Type:</th>
                            <td><a href="#ModeOfTransport">ModeOfTransport</a></td>
                        </tr>
                    </table>
                    
                    <p>
                        The <code><a href='#Subway'>Subway</a></code> individual represents transport realized underground by trains.
                    </p>

                    <p style="float: right; font-size: small;">[<a href="#Subway">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>
                
                <div class="specterm individualterm " id="Tram" about="http://dpp-news.appspot.com/vocab/public-transport#Tram" typeof="rdfs:Resource">
                    
                    <h3>Individual: pubtrans:Tram</h3> 
                    
                    <em>Tram</em> - A tram.<br />
                    
                    <table style="th { float: top; }">
                        <tr>
                            <th>Status:</th>
                            <td><span property="vs:status" >stable</span></td>
                        </tr>
                        
                        <tr>
                            <th>Type:</th>
                            <td><a href="#ModeOfTransport">ModeOfTransport</a></td>
                        </tr>
                    </table>
                    
                    <p>
                        The <code><a href='#Tram'>Tram</a></code> individual represents transport realized by trams.
                    </p>

                    <p style="float: right; font-size: small;">[<a href="#Tram">#</a>] [<a href="#sec-toc">back to top</a>]</p>
                    <br/>
                </div>



            </div>
        </div>
    </body>
</html>

