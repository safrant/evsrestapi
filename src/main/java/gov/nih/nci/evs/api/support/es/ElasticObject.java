
package gov.nih.nci.evs.api.support.es;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import gov.nih.nci.evs.api.model.AssociationEntry;
import gov.nih.nci.evs.api.model.BaseModel;
import gov.nih.nci.evs.api.model.Concept;
import gov.nih.nci.evs.api.model.ConceptMinimal;
import gov.nih.nci.evs.api.model.Paths;
import gov.nih.nci.evs.api.service.ElasticOperationsService;
import gov.nih.nci.evs.api.util.HierarchyUtils;

/**
 * The elasticsearch wrapper object for cached objects
 * 
 * @author Arun
 *
 */
@Document(indexName = "default_object", type = ElasticOperationsService.OBJECT_TYPE)
@JsonInclude(content = Include.NON_EMPTY)
public class ElasticObject extends BaseModel {

  @Id
  private String name;

  @Field(type = FieldType.Object)
  private HierarchyUtils hierarchy;

  @Field(type = FieldType.Object)
  private Paths paths;

  @Field(type = FieldType.Nested)
  private List<Concept> concepts;

  @Field(type = FieldType.Nested)
  private List<ConceptMinimal> conceptMinimals;

  @Field(type = FieldType.Object)
  private List<AssociationEntry> associationEntries;

  public ElasticObject() {
  }

  public ElasticObject(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HierarchyUtils getHierarchy() {
    return hierarchy;
  }

  public void setHierarchy(HierarchyUtils hierarchy) {
    this.hierarchy = hierarchy;
  }

  public Paths getPaths() {
    return paths;
  }

  public void setPaths(Paths paths) {
    this.paths = paths;
  }

  /**
   * Returns the concepts.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    if (concepts == null) {
      concepts = new ArrayList<>();
    }
    return concepts;
  }

  public void setConcepts(List<Concept> concepts) {
    this.concepts = concepts;
  }

  public List<ConceptMinimal> getConceptMinimals() {
    if (conceptMinimals == null) {
      conceptMinimals = new ArrayList<>();
    }
    return conceptMinimals;
  }

  public void setConceptMinimals(List<ConceptMinimal> conceptMinimals) {
    this.conceptMinimals = conceptMinimals;
  }

  public List<AssociationEntry> getAssociationEntries() {
    return associationEntries;
  }

  public void setAssociationEntries(List<AssociationEntry> associationEntries) {
    this.associationEntries = associationEntries;
  }
}
