package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.thrift.gen.ThriftAffiliation;
import com.copyright.rup.works.broker.thrift.gen.ThriftAuthor;
import com.copyright.rup.works.broker.thrift.gen.ThriftPerson;
import com.copyright.rup.works.broker.thrift.gen.ThriftPublisher;
import com.copyright.rup.works.broker.thrift.gen.ThriftSubject;
import com.copyright.rup.works.broker.thrift.gen.ThriftTitle;
import com.copyright.rup.works.broker.thrift.gen.ThriftWork;
import com.copyright.rup.works.broker.thrift.gen.ThriftWorkCollection;
import com.copyright.rup.works.broker.thrift.gen.ThriftWorkLanguage;
import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Affiliation;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.Contributor;
import com.copyright.rup.works.domain.impl.Editor;
import com.copyright.rup.works.domain.impl.Publisher;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Title;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * The builder for ThriftWork structure.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Pavel_Yakovlev
 */
public final class ThriftConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftConverter.class);

    /**
     * Converts IWork domain to ThriftWork thrift structure.
     * @param work work domain object.
     * @return thrifrWork thrift structure.
     */
    public static ThriftWork convertFrom(IWork work) {
        ThriftWork thriftWork = new ThriftWork();
        thriftWork.setId(work.getId());

        thriftWork.setAuthors(generateThriftAuthors(work.getAuthors()));

        ThriftWorkCollection thriftWorkCollection = new ThriftWorkCollection();
        thriftWorkCollection.setCollectionName(work.getCollection().getCollectionName());
        thriftWorkCollection.setCollectionType(work.getCollection().getCollectionType());
        thriftWorkCollection.setDataProvider(work.getCollection().getDataProvider());
        thriftWorkCollection.setSubmittedByUser(work.getCollection().getSubmittedByUser());
        thriftWorkCollection.setSubmittedDatetime(work.getCollection().getSubmittedDatetime()
                .toString());
        thriftWorkCollection.setSubmittedProcessedDatetime(work.getCollection()
                .getSubmitProcessedDatetime().toString());
        thriftWorkCollection.setCreateByFileSubmittedPath(work.getCollection()
                .getCreateByFileSubmittedPath());
        thriftWorkCollection.setCreateByfileOsFilePath(work.getCollection()
                .getCreateByFileOSFilePath());
        thriftWorkCollection.setImportFileType(work.getCollection().getImportFileType());
        thriftWorkCollection.setImportFileContentType(work.getCollection()
                .getImportFileContentType());
        thriftWork.setCollection(thriftWorkCollection);

        thriftWork.setContributors(generateThriftContributers(work.getContributors()));

        thriftWork.setEditors(generateTriftEditors(work.getEditors()));

        ThriftWorkLanguage thriftWorkLanguage = new ThriftWorkLanguage();
        thriftWorkLanguage.setLanguage(work.getLanguage().getLanguage());
        thriftWorkLanguage.setLanguageRole(work.getLanguage().getLanguageRole());
        thriftWork.setWorkLanguage(thriftWorkLanguage);
        thriftWork.setPublicationType(work.getPublicationType());
        thriftWork.setPuclicationCountry(work.getPublicationCountry());

        thriftWork.setPublisher(generateThriftPublishers(work.getPublisher()));

        ThriftSubject thriftSubject = new ThriftSubject();
        thriftSubject.setSubject(work.getSubject().getSubject());
        thriftSubject.setSubjectType(work.getSubject().getSubjectType());
        thriftWork.setSubject(thriftSubject);

        thriftWork.setTitles(generateThriftTitles(work.getTitles()));

        thriftWork.setAudience(work.getAudience());

        return thriftWork;
    }

    /**
     * Converts ThriftWork thrift structure to Work domain.
     * @param thriftWork ThriftWork thrift class.
     * @return work Work domain.
     */
    public static IWork convertTo(ThriftWork thriftWork) {

        IWork work = new Work();
        work.setId(thriftWork.getId());

        work.setAuthors(generateDomainAuthors(thriftWork.getAuthors()));

        WorkCollection workCollection = new WorkCollection();
        workCollection.setCollectionName(thriftWork.getCollection().getCollectionName());
        workCollection.setCollectionType(thriftWork.getCollection().getCollectionType());
        workCollection.setDataProvider(thriftWork.getCollection().getDataProvider());
        workCollection.setSubmittedByUser(thriftWork.getCollection().getSubmittedByUser());
        workCollection.setCreateByFileSubmittedPath(thriftWork.getCollection()
                .getCreateByFileSubmittedPath());
        workCollection.setCreateByFileOSFilePath((thriftWork.getCollection()
                .getCreateByfileOsFilePath()));
        workCollection.setImportFileType(thriftWork.getCollection().getImportFileType());
        workCollection.setImportFileContentType(thriftWork.getCollection()
                .getImportFileContentType());
        work.setCollection(workCollection);

        work.setContributors(generateDomainContributers(thriftWork.getContributors()));

        work.setEditors(generateDomainEditors(thriftWork.getEditors()));

        IWorkLanguage workLanguage = new WorkLanguage();
        workLanguage.setLanguage(thriftWork.getWorkLanguage().getLanguage());
        workLanguage.setLanguageRole(thriftWork.getWorkLanguage().getLanguageRole());
        work.setLanguage(workLanguage);

        work.setPublicationType(thriftWork.getPublicationType());
        work.setPublicationCountry(thriftWork.getPuclicationCountry());

        IPublisher publisher = new Publisher();
        publisher.setName(thriftWork.getPublisher().getName());
        publisher.setPublicationPlace(thriftWork.getPublisher().getPublicationPlace());
        publisher.setRole(thriftWork.getPublisher().getRole());
        publisher.setStatus(thriftWork.getPublisher().getStatus());
        publisher.setSortOrder(thriftWork.getPublisher().getSortOrder());
        work.setPublisher(publisher);

        ISubject subject = new Subject();
        subject.setSubject(thriftWork.getSubject().getSubject());
        subject.setSubjectType(thriftWork.getSubject().getSubjectType());
        work.setSubject(subject);

        work.setTitles(generateDomainTitles(thriftWork.getTitles()));

        work.setAudience(thriftWork.getAudience());
        return work;
    }

    private static List<ThriftPerson> generateThriftContributers(List<IContributor> contributors) {
        List<ThriftPerson> persons = new LinkedList<ThriftPerson>();
        for (IContributor contributor: contributors) {
            ThriftPerson thriftPerson = new ThriftPerson();
            thriftPerson.setName(contributor.getName());
            thriftPerson.setRole(contributor.getRole());
            ThriftAffiliation thriftAffiliation = new ThriftAffiliation();
            thriftAffiliation.setAddress(contributor.getAffiliation().getAddress());
            thriftAffiliation.setCountry(contributor.getAffiliation().getCountry());
            thriftPerson.setAffiliation(thriftAffiliation);
            persons.add(thriftPerson);
        }
        return persons;
    }

    private static List<ThriftPerson> generateTriftEditors(List<IEditor> editors) {
        List<ThriftPerson> persons = new LinkedList<ThriftPerson>();
        for (IEditor editor: editors) {
            ThriftPerson thriftPerson = new ThriftPerson();
            thriftPerson.setName(editor.getName());
            thriftPerson.setRole(editor.getRole());
            ThriftAffiliation thriftAffiliation = new ThriftAffiliation();
            thriftAffiliation.setAddress(editor.getAffiliation().getAddress());
            thriftAffiliation.setCountry(editor.getAffiliation().getCountry());
            thriftPerson.setAffiliation(thriftAffiliation);
            persons.add(thriftPerson);
        }
        return persons;
    }

    private static List<ThriftTitle> generateThriftTitles(List<ITitle> titles) {
        List<ThriftTitle> thriftTitles = new LinkedList<ThriftTitle>();
        for (ITitle title: titles) {
            ThriftTitle thriftTitle = new ThriftTitle();
            thriftTitle.setTitle(title.getTitle());
            thriftTitle.setEdition(title.getEdition());
            thriftTitle.setType(title.getType());
            thriftTitle.setVolume(title.getVolume());
            thriftTitles.add(thriftTitle);
        }
        return thriftTitles;
    }

    private static List<ThriftAuthor> generateThriftAuthors(List<IAuthor> authors) {
        List<ThriftAuthor> thriftAuthors = new LinkedList<ThriftAuthor>();
        for (IAuthor author: authors) {
            ThriftAuthor thriftAuthor = new ThriftAuthor();
            thriftAuthor.setBirthYear(author.getBirthYear());
            thriftAuthor.setDeathYear(author.getDeathYear());
            thriftAuthors.add(thriftAuthor);
        }
        return thriftAuthors;
    }

    private static List<IAuthor> generateDomainAuthors(List<ThriftAuthor> thriftAuthors) {
        List<IAuthor> authors = new LinkedList<>();
        for (ThriftAuthor thriftAuthor : thriftAuthors) {
            IAuthor author = new Author();
            author.setBirthYear(thriftAuthor.getBirthYear());
            author.setDeathYear(thriftAuthor.getDeathYear());
            authors.add(author);
        }
        return authors;
    }

    private static ThriftPublisher generateThriftPublishers(IPublisher publisher) {
        ThriftPublisher thriftPublisher = new ThriftPublisher();
        thriftPublisher.setName(publisher.getName());
        thriftPublisher.setPublicationPlace(publisher.getPublicationPlace());
        thriftPublisher.setRole(publisher.getRole());
        thriftPublisher.setStatus(publisher.getStatus());
        thriftPublisher.setSortOrder(publisher.getSortOrder());
        return thriftPublisher;
    }

    private static List<IContributor> generateDomainContributers(List<ThriftPerson> thriftPersons) {
        List<IContributor> contributors = new LinkedList<IContributor>();
        for (ThriftPerson thriftContributor: thriftPersons) {
            IContributor contributor = new Contributor();
            contributor.setName(thriftContributor.getName());
            contributor.setRole(thriftContributor.getRole());
            IAffiliation affiliation = new Affiliation();
            affiliation.setAddress(thriftContributor.getAffiliation().getAddress());
            affiliation.setCountry(thriftContributor.getAffiliation().getCountry());
            contributor.setAffiliation(affiliation);
            contributors.add(contributor);
        }
        return contributors;
    }

    private static List<IEditor> generateDomainEditors(List<ThriftPerson> thriftPersons) {
        List<IEditor> editors = new LinkedList<IEditor>();
        for (ThriftPerson thriftEditor: thriftPersons) {
            IEditor editor = new Editor();
            editor.setName(thriftEditor.getName());
            editor.setRole(thriftEditor.getRole());
            IAffiliation affiliation = new Affiliation();
            affiliation.setAddress(thriftEditor.getAffiliation().getAddress());
            affiliation.setCountry(thriftEditor.getAffiliation().getCountry());
            editor.setAffiliation(affiliation);
            editors.add(editor);
        }
        return editors;
    }

    private static List<ITitle> generateDomainTitles(List<ThriftTitle> thriftTitles) {
        List<ITitle> titles = new LinkedList<ITitle>();
        for (ThriftTitle thriftTitle: thriftTitles) {
            ITitle title = new Title();
            title.setTitle(thriftTitle.getTitle());
            title.setEdition(thriftTitle.getEdition());
            title.setType(thriftTitle.getType());
            title.setVolume(thriftTitle.getVolume());
            titles.add(title);
        }
        return titles;
    }
}
